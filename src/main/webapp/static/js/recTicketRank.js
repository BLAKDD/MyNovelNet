var time = new Date();
let year = time.getFullYear();
let month = time.getMonth() + 1;
let userUuid = getCookiebyName("userUuid");
let choseCategory = 'all'
let choseRankCategory = '_week_recom'
let bookstoreList;


function initPage() {
    if (month < 10) {
        month = '0' + month
    }
    if (userUuid == '') {
        getRecTicketWeekRankList()
    } else {
        getBookStoreList()
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


function changeCategory(category) {
    document.getElementById(choseCategory).setAttribute("class", "ready")
    document.getElementById(category).setAttribute("class", "chose")
    choseCategory = category
    refreshList()
}

function changeRank(rankCategory) {
    document.getElementById(choseRankCategory).setAttribute("class", '')
    document.getElementById(rankCategory).setAttribute("class", 'act')
    choseRankCategory = rankCategory
    refreshList()
}

function getBookStoreList() {
    $.ajax({
        type: 'POST',
        url: '/book/getBookstoreList',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'userUuid',
            value: userUuid
        }],
        success: function (data) {
            bookstoreList = data
            getRecTicketWeekRankList()
        },
        error: function () {
            alert("获取书架信息出错");
        }
    });
}

function getRecTicketList() {
    let key = ''
    if (choseRankCategory == '_month_recom') {
        key = choseCategory + choseRankCategory + year + month
    } else {
        key = choseCategory + choseRankCategory
    }
    console.log(key)
    $.ajax({
        type: 'POST',
        url: '/rank/getRecTicketRankDetail',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'key',
            value: key
        }, {
            name: 'front',
            value: 1
        }, {
            name: 'after',
            value: 10
        }],
        success: function (data) {
            initBookList(data)
        },
        error: function () {
            alert("获取排行榜书籍详细信息出错");
        }
    });
}

function getRecTicketWeekRankList() {
    let key = choseCategory + choseRankCategory
    console.log(key)
    $.ajax({
        type: 'POST',
        url: '/rank/getRecTicketWeekRankDetail',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'key',
            value: key
        }, {
            name: 'front',
            value: 1
        }, {
            name: 'after',
            value: 10
        }],
        success: function (data) {
            for (let i = 0; i < data.length; i++) {
                console.log(data[i].novelName)
            }
            initBookList(data)
        },
        error: function () {
            alert("获取排行榜书籍详细信息出错");
        }
    });
}

function refreshList() {
    if (choseRankCategory == '_week_recom') {
        getRecTicketWeekRankList()
    } else {
        getRecTicketList()
    }
}

function initBookList(data) {
    let bookList = document.getElementById('bookList')
    bookList.innerHTML = ''
    for (let i = 0; i < data.length; i++) {
        let content = document.createElement("li")
        //content.setAttribute("data-rid", data[i].rank)
        let bookImageBox = document.createElement("div")
        let rankTag = document.createElement("span")
        let cite = document.createElement("cite")
        let imagea = document.createElement("a")
        let cover = document.createElement("img")
        bookImageBox.setAttribute("class", "book-img-box")
        rankTag.setAttribute("class", "rank-tag no" + data[i].rank)
        rankTag.innerHTML = data[i].rank
        imagea.setAttribute("href", "bookInfo?novelUuid=" + data[i].novelUuid)
        imagea.setAttribute("target", '_blank')
        cover.src = "/file/getFile?fileId=" + data[i].novelUuid + "&size=150"
        imagea.append(cover)
        rankTag.append(cite)
        bookImageBox.append(rankTag)
        bookImageBox.append(imagea)
        content.append(bookImageBox)

        let bookMidInfo = document.createElement("div")
        let h4 = document.createElement("h4")
        let bookName = document.createElement('a')
        let author = document.createElement('p')
        let authorName = document.createElement('a')
        let em1 = document.createElement('em')
        let pcategory = document.createElement('a')
        let em2 = document.createElement('em')
        let state = document.createElement('span')
        bookMidInfo.setAttribute("class", 'book-mid-info')
        bookName.setAttribute("href", "bookInfo?novelUuid=" + data[i].novelUuid)
        bookName.innerHTML = data[i].novelName
        bookName.setAttribute("target", "_blank")
        h4.append(bookName)
        bookMidInfo.append(h4)
        authorName.setAttribute("class", "name")
        authorName.setAttribute("href", "javascript:void(0)")
        authorName.innerHTML = data[i].writerName
        em1.innerHTML = "丨"
        pcategory.setAttribute("href", "javascript:void(0)")
        pcategory.innerHTML = data[i].pCategory
        em2.innerHTML = '丨'
        state.innerHTML = data[i].status = 1 ? '连载' : '完本'
        author.append(authorName)
        author.append(em1)
        author.append(pcategory)
        author.append(em2)
        author.append(state)
        bookMidInfo.append(author)
        let intro = document.createElement('p')
        let update = document.createElement('p')
        let newestChapter = document.createElement('a')
        let em3 = document.createElement('em')
        let updateTime = document.createElement('span')
        intro.setAttribute("class", 'intro')
        intro.innerHTML = data[i].introduction
        bookMidInfo.append(intro)
        update.setAttribute("class", 'update')
        newestChapter.setAttribute("target", "_blank")
        newestChapter.setAttribute("href", "javascript:void(0)")
        newestChapter.innerHTML = "最新更新 " + data[i].newestChapterName;
        em3.innerHTML = '·'
        updateTime.innerHTML = data[i].updateTime;
        update.append(newestChapter)
        update.append(em3)
        update.append(updateTime)
        bookMidInfo.append(update)
        content.append(bookMidInfo)

        let bookRightInfo = document.createElement('div')
        let total = document.createElement('div')
        let scores = document.createElement('p')
        let btns = document.createElement('p')
        let bookDetail = document.createElement('a')
        let bookshelf = document.createElement('a')
        bookRightInfo.setAttribute("class", 'book-right-info')
        total.setAttribute("class", "total")
        scores.innerHTML = data[i].score + " 月票"
        total.append(scores)
        bookRightInfo.append(total)
        btns.setAttribute('class', 'btn')
        bookDetail.setAttribute("class", 'red-btn')
        bookDetail.setAttribute("href", "bookInfo?novelUuid=" + data[i].novelUuid)
        bookDetail.setAttribute("target", '_blank')
        bookDetail.innerHTML = "书籍详情"
        bookshelf.setAttribute("class", 'blue-btn')
        bookshelf.setAttribute('href', "javascript:")
        bookshelf.onclick = function () {
            addToBookstore(data[i].novelUuid, bookshelf);
        }
        if (bookstoreList == null) {
            bookshelf.innerHTML = "加入书架"
        } else {
            if (bookstoreList.indexOf(data[i].novelUuid) > -1) {
                bookshelf.innerHTML = "已在书架"
                bookshelf.onclick = function () {
                }
            } else {
                bookshelf.innerHTML = "加入书架"
            }
        }

        btns.append(bookDetail)
        btns.append(bookshelf)
        bookRightInfo.append(btns)
        content.append(bookRightInfo)
        bookList.append(content)
    }
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
                btn.onclick = function () {
                }
            } else {
                alert("加入书架失败")
            }

        },
        error: function () {
            alert("加入书架失败");
        }
    });
}

initPage()