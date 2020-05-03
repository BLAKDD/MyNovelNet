var info, catalogue, w_info, w_menu
var input, limit, comment, ifBookShelf, readProgress
var novelUuid = getCookiebyName("novelUuid")
let userUuid = getCookiebyName("userUuid")

function init() {
    info = document.getElementById("workinfo")
    catalogue = document.getElementById("catalogue")
    w_info = document.getElementById("w_info")
    w_menu = document.getElementById("w_menu")
    input = document.getElementById("input")
    limit = document.getElementById("limit")
    readProgress = document.getElementById('readProgress')
    ifBookShelf = document.getElementById('ifBookShelf')
    comment = document.getElementById('comment')
    w_info.setAttribute("class", "info-menu-selected")
    getNovelInfoPageNovelData()
    getWeekRecScoreByUuid()
    getNovelDetailIntro()
    getNovelCatalogShow()
    getChapterSum()
    ifBookShelf.onclick = function () {
        if (userUuid) {
            addToBookstore(novelUuid, ifBookShelf)
        } else {
            document.getElementById("loginDialog").showModal()
        }
    }
    if (userUuid) {
        initReadProgressLogined();
        initIfInBookShelf();
    } else {
        initReadProgressNotLogined();
    }
}


function addEvent() {
    w_info.addEventListener("click", function () {
        info.style.display = "flex"
        w_info.setAttribute("class", "info-menu-selected")
        catalogue.style.display = "none"
        w_menu.removeAttribute("class")
    })

    w_menu.addEventListener("click", function () {
        info.style.display = "none"
        w_info.removeAttribute("class")
        catalogue.style.display = "block"
        w_menu.setAttribute("class", "info-menu-selected")
    })

    input.oninput = function () {
        limit.innerHTML = `还剩${150 - input.value.length}字`
    }
}

function getCookiebyName(name) {
    var strcookie = document.cookie;//获取cookie字符串
    var arrcookie = strcookie.split("; ");//分割
    //遍历匹配
    for (var i = 0; i < arrcookie.length; i++) {
        var arr = arrcookie[i].split("=");
        if (arr[0] == name) {
            return arr[1];
        }
    }
    return "";
}

function getNovelInfoPageNovelData() {
    $.ajax({
        type: 'POST',
        url: '/book/getNovelInfoPageNovelData',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'novelUuid',
            value: novelUuid
        }],
        success: function (data) {
            let topCategoryList = document.getElementById('topCategoryList')
            let topa1 = document.createElement('a')
            let topem1 = document.createElement('em')
            let topa2 = document.createElement('a')
            let topem2 = document.createElement('em')
            let topa3 = document.createElement('a')
            topa1.setAttribute("href", "javascript:;");
            topa1.innerHTML = data.pCategory;
            topa2.setAttribute("href", "javascript:;");
            topa2.innerHTML = data.category;
            topa3.setAttribute("href", "javascript:;");
            topa3.innerHTML = data.novelName;
            topem1.setAttribute("class", "iconfont");
            topem1.innerHTML = '&#xe621;'
            topem2.setAttribute("class", "iconfont");
            topem2.innerHTML = '&#xe621;'
            topCategoryList.append(topa1)
            topCategoryList.append(topem1)
            topCategoryList.append(topa2)
            topCategoryList.append(topem2)
            topCategoryList.append(topa3)
            document.getElementById('bookCover').src = "/file/getFile?fileId=" + novelUuid + "&size=180";
            document.getElementById('novelNameId').innerHTML = data.novelName
            document.getElementById('writerNameId').innerHTML = data.writerName + " 著"
            document.getElementById('pageTitle').innerHTML = "《" + data.novelName + "》_" + data.writerName
            document.getElementById("stateId").innerHTML = data.state == 1 ? "连载" : "完结"
            document.getElementById("ifSignId").innerHTML = data.ifSigning == 1 ? "签约" : "新书"
            document.getElementById("ifVipId").innerHTML = data.ifVip == 1 ? 'VIP' : "免费"
            document.getElementById('pCategoryId').innerHTML = data.pCategory
            document.getElementById('categoryId').innerHTML = data.category
            document.getElementById('introductionId').innerHTML = data.introduction
            getWriterInfo(data.writerUuid)
            document.getElementById('wordCountId').innerHTML = (data.wordCount / 10000).toFixed(2) + "<span class=\"num-unit\">万字</span>"
        },
        error: function () {
            alert("获取小说信息");
        }
    });
}

function getWholeRecScoreByUuid() {
    $.ajax({
        type: 'POST',
        url: '/rank/getWholeRecScoreByUuid',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'novelUuid',
            value: novelUuid
        }],
        success: function (data) {
            let allRecCountElement = document.getElementById('allRecCountId')
            if (data >= 10000) {
                allRecCountElement.innerHTML = (data / 10000).toFixed(2) + "<span class=\"num-unit\">万总推荐</span>"
            } else {
                allRecCountElement.innerHTML = data + "<span class=\"num-unit\">总推荐</span>"
            }
        },
        error: function () {
            alert("获取总推荐数出错");
        }
    });
}

function getWeekRecScoreByUuid() {
    $.ajax({
        type: 'POST',
        url: '/rank/getWeekRecScoreByUuid',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'novelUuid',
            value: novelUuid
        }],
        success: function (data) {
            document.getElementById('weekRecCountId').innerHTML = data + "<span class=\"num-unit\">周推荐</span>"
        },
        error: function () {
            alert("获取周推荐出错");
        }
    });
}

function getNovelDetailIntro() {
    $.ajax({
        type: 'POST',
        url: '/book/getNovelDetailIntro',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'novelUuid',
            value: novelUuid
        }],
        success: function (data) {
            let detailIntroEl = document.getElementById('novelDetailIntroId')
            let content = '';
            for (let i = 0, len = data.length; i < len; i++) {
                content += data[i] + "<br>"
            }
            detailIntroEl.innerHTML = content
        },
        error: function () {
            alert("获取小说详细介绍出错");
        }
    });
}

function getNovelCatalogShow() {
    $.ajax({
        type: 'POST',
        url: '/book/getNovelCatalogShow',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'novelUuid',
            value: novelUuid
        }],
        success: function (data) {
            let newestChapter;
            let catalogue = document.getElementById("catalogue")
            for (let key in data) {
                let volume = JSON.parse(key)
                let volumeWhole = document.createElement('div')
                let volumeHead = document.createElement('div')
                let volumeName = document.createElement('span')
                let ifVip = document.createElement('span')
                let volumeWordCount = document.createElement('span')
                volumeWhole.setAttribute("class", "volume")
                volumeHead.setAttribute("calss", "volume-head")
                volumeName.setAttribute("class", "book-name")
                volumeName.innerHTML = volume.volumeName + '·共' + volume.chapterCount + "章"
                if (volume.ifVip == 1) {
                    ifVip.setAttribute("class", "vip")
                    ifVip.innerHTML = 'VIP'
                } else {
                    ifVip.setAttribute("class", "free")
                    ifVip.innerHTML = '免费'
                }
                volumeWordCount.setAttribute("class", "num-intro")
                volumeWordCount.innerHTML = '本卷一共' + volume.volumeWorkCount + '字'
                volumeHead.append(volumeName)
                volumeHead.append(ifVip)
                volumeHead.append(volumeWordCount)
                volumeWhole.append(volumeHead)
                let chapterList = document.createElement('ul')
                chapterList.setAttribute("class", "chapter")
                for (let i = 0; i < data[key].length; i++) {
                    let li1 = document.createElement('li')
                    let chapter = document.createElement('a')
                    chapter.innerHTML = data[key][i].chapterName
                    li1.append(chapter)
                    chapterList.append(li1)
                    newestChapter = data[key][i]
                }
                volumeWhole.append(chapterList)
                catalogue.append(volumeWhole)
                document.getElementById('newestChapter').innerHTML = newestChapter.chapterName
                document.getElementById('lastupdataTime').innerHTML = newestChapter.modtime
            }
        },
        error: function () {
            alert("获取目录失败");
        }
    });
}

function getWriterInfo(writerUuid) {
    $.ajax({
        type: 'POST',
        url: '/getWriterInfo',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'writerUuid',
            value: writerUuid
        }],
        success: function (data) {
            document.getElementById('writerLevelId').innerHTML = 'Lv.' + data.writerLevel;
            document.getElementById('rightWriterNameId').innerHTML = data.userName;
            document.getElementById('novelCountId').innerHTML = data.novelCount;
            document.getElementById('writerWordCountId').innerHTML = (data.wordCount / 10000).toFixed(2) + "万";
            document.getElementById('updateCountId').innerHTML = data.updateCount;

        },
        error: function () {
            alert("获取作者详情失败");
        }
    });
}

function getChapterSum() {
    $.ajax({
        type: 'POST',
        url: '/book/getChapterSum',
        dataType: 'text',
        cache: false,
        data: [{
            name: 'novelUuid',
            value: novelUuid
        }],
        success: function (data) {
            document.getElementById('chapterSum').innerHTML = data

        },
        error: function () {
            alert("章节总数获取失败");
        }
    });
}

function initReadProgressLogined() {
    $.ajax({
        type: 'POST',
        url: '/book/getReadProgress',
        dataType: 'text',
        cache: false,
        data: [{
            name: 'novelUuid',
            value: novelUuid
        }, {
            name: 'userUuid',
            value: userUuid
        }],
        success: function (data) {
            if (data) {
                readProgress.innerHTML = '继续阅读'
                readProgress.href = "/read?novelUuid=" + novelUuid + "&chapterUuid=" + data;
            } else {
                initReadProgressNotLogined();
            }
        },
        error: function () {
            alert('getReadProgress error')
        }
    });
}


function initReadProgressNotLogined() {
    $.ajax({
        type: 'POST',
        url: '/book/getFirstChapterUuid',
        dataType: 'text',
        cache: false,
        data: [{
            name: 'novelUuid',
            value: novelUuid
        }],
        success: function (data) {
            if (data) {
                readProgress.href = "/read?novelUuid=" + novelUuid + "&chapterUuid=" + data;
            } else {
                readProgress.style.pointerEvents = 'none'
            }

        },
        error: function () {
            alert('getFirstChapterUuid error')
        }
    });
}

function initIfInBookShelf() {
    $.ajax({
        type: 'POST',
        url: '/book/ifInBookShelf',
        dataType: 'text',
        cache: false,
        data: [{
            name: 'userUuid',
            value: userUuid
        }, {
            name: 'novelUuid',
            value: novelUuid
        }],
        success: function (data) {
            if (data == 1) {
                ifBookShelf.innerHTML = '已在书架'
                ifBookShelf.style.pointerEvents = 'none'
            }
        },
        error: function () {
            alert('getFirstChapterUuid error')
        }
    });
}

function addToBookstore(novelUuid, btn) {
    $.ajax({
        type: 'POST',
        url: '/book/addToBookstore',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'userUuid',
            value: userUuid
        }, {
            name: 'novelUuid',
            value: novelUuid
        }],
        success: function (data) {
            if (data == 1) {
                alert("成功加入书架")
                btn.innerHTML = "已在书架"
                btn.style.pointerEvents = "none"
            } else {
                alert("加入书架失败")
            }

        },
        error: function () {
            alert("加入书架失败");
        }
    });
}

init()
addEvent()