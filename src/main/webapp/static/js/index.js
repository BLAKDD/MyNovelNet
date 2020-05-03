var width = document.getElementById('book_box').clientWidth
var cwidth = document.getElementById('book_1').clientWidth
var list = [
    document.getElementById('book_1'),
    document.getElementById('book_2'),
    document.getElementById('book_3'),
    document.getElementById('book_4'),
    document.getElementById('book_5'),
    document.getElementById('book_6'),
    document.getElementById('book_7'),
]
var listImg = [
    document.getElementById('editor_rec_imgg1'),
    document.getElementById('editor_rec_imgg2'),
    document.getElementById('editor_rec_imgg3'),
    document.getElementById('editor_rec_imgg4'),
    document.getElementById('editor_rec_imgg5'),
    document.getElementById('editor_rec_imgg6'),
    document.getElementById('editor_rec_imgg7'),
]

var coverRecImgList = [
    document.getElementById('coverRecimg1'),
    document.getElementById('coverRecimg2'),
    document.getElementById('coverRecimg3'),
    document.getElementById('coverRecimg4'),
    document.getElementById('coverRecimg5'),
]


var middle = 3
var editorRecomData
var flag = true

function getcount() {
    $.ajax({
        type: 'POST',
        url: '/getCount',
        dataType: 'json',
        cache: false,
        data: [],
        success: function (data) {
            alert(data);
        },
        error: function () {
            alert("getCount失败");
        }
    });
}

function getNewest5CoverRecom() {
    $.ajax({
        type: 'POST',
        url: '/getNewest5CoverRecom',
        dataType: 'json',
        cache: false,
        data: [],
        success: function (data) {
            let coverRecNovelNameList = [
                document.getElementById('coverRecNovelName1'),
                document.getElementById('coverRecNovelName2'),
                document.getElementById('coverRecNovelName3'),
                document.getElementById('coverRecNovelName4'),
                document.getElementById('coverRecNovelName5'),
            ]
            for (let i = 0, len = data.length; i < len; i++) {
                coverRecNovelNameList[i].innerHTML = data[i].novelName;
                coverRecImgList[i].src = "/file/getCoverRecomImage?startTime=" + data[i].startTime
            }
        },
        error: function () {
            alert("获取封推失败");
        }
    });
}

function getNewestStrongRecom() {
    $.ajax({
        type: 'POST',
        url: '/getNewestStrongRecom',
        dataType: 'json',
        cache: false,
        data: [],
        success: function (data) {
            let strongrecom = document.getElementById("thisweekSR");
            for (let i = 0, len = data.length; i < len; i++) {
                let cate = document.createElement("li");
                let a1 = document.createElement("a");
                let a2 = document.createElement("a");
                let a3 = document.createElement("a");
                a1.setAttribute("href", "javascript:;");
                a1.innerHTML = "[" + data[i].pCategory + "] ";
                a2.setAttribute("href", "bookInfo?novelUuid=" + data[i].novelUuid);
                a2.setAttribute("target", "_blank");
                a2.innerHTML = data[i].novelName;
                a3.setAttribute("href", "javascript:;");
                a3.setAttribute("class", "author");
                a3.innerHTML = data[i].writerName;
                cate.append(a1);
                cate.append(a2);
                cate.append(a3);
                strongrecom.append(cate);
            }
        },
        error: function () {
            alert("获取本周强推失败");
        }
    });
}

function getNewestSanJiang() {
    $.ajax({
        type: 'POST',
        url: '/getNewestSanJiang',
        dataType: 'json',
        cache: false,
        data: [],
        success: function (data) {
            let sanjiang = document.getElementById("thisweekSJ");
            for (let i = 0, len = data.length; i < len; i++) {
                let cate = document.createElement("li");
                let a1 = document.createElement("a");
                let a2 = document.createElement("a");
                let a3 = document.createElement("a");
                a1.setAttribute("href", "javascript:;");
                a1.innerHTML = "[" + data[i].pCategory + "] ";
                a2.setAttribute("href", "bookInfo?novelUuid=" + data[i].novelUuid);
                a2.setAttribute("target", "_blank");
                a2.innerHTML = data[i].novelName;
                a3.setAttribute("href", "javascript:;");
                a3.setAttribute("class", "author");
                a3.innerHTML = data[i].writerName;
                cate.append(a1);
                cate.append(a2);
                cate.append(a3);
                sanjiang.append(cate);
            }
        },
        error: function () {
            alert("获取本周三江失败");
        }
    });
}

function getEditorRecom() {
    $.ajax({
            type: 'POST',
            url: '/getEditorRecom',
            cache: false,
            data: [],
            success: function (data) {
                editorRecomData = data;
                for (let n = 0; n < 7; n++) {
                    listImg[n].src = "/file/getFile?fileId=" + data[n].novelUuid + "&size=90";
                }
                let editorRecomTitle = document.getElementById("editorRecomTitle")
                let editorRecomIntro = document.getElementById("editorRecomIntro")
                let bookInfo = document.getElementById("bookInfo")
                editorRecomTitle.innerHTML = data[3].novelName;
                editorRecomIntro.innerHTML = data[3].intro;
                bookInfo.setAttribute("href", "bookInfo?novelUuid=" + data[3].novelUuid);
                let editorRecomListUp = document.getElementById("editorRecomListUp");
                let editorRecomListDown = document.getElementById("editorRecomListDown");
                for (let i = 7; i < 13; i++) {
                    let div = document.createElement("div")
                    let p1 = document.createElement("p")
                    let strong = document.createElement("strong")
                    let span = document.createElement("span")
                    let p2 = document.createElement("p")
                    div.setAttribute("class", "det-list-item")
                    p1.innerHTML = data[i].novelName
                    p1.setAttribute("onclick", "location.href='bookInfo?novelUuid='" + data[i].novelUuid)
                    strong.innerHTML = 999999
                    span.innerHTML = "人在追"
                    span.setAttribute("style", "font-size:12px")
                    p2.innerHTML = data[i].intro
                    div.append(p1)
                    div.append(strong)
                    div.append(span)
                    div.append(p2)
                    if (i < 10) {
                        editorRecomListUp.append(div)
                    } else {
                        editorRecomListDown.append(div)
                    }
                }
            },
            error: function () {
                alert("获取本周编辑推荐失败");
            }
        }
    )
    ;
}

function getLastWeekRecomTop10() {
    $.ajax({
        type: 'POST',
        url: '/getLastWeekRecomTop10',
        dataType: 'json',
        cache: false,
        data: [],
        success: function (data) {
            renderingRank(data, "recom_ticket_list")
        },
        error: function () {
            alert("获取推荐票榜前10失败");
        }
    });
}

function getLastMonthTicketTop10() {
    $.ajax({
        type: 'POST',
        url: '/getLastMonthTicketTop10',
        dataType: 'json',
        cache: false,
        data: [],
        success: function (data) {
            renderingRank(data, "month_ticket_rank")
        },
        error: function () {
            alert("获取月票榜前10失败");
        }
    });
}

function getCollectionTop10() {
    $.ajax({
        type: 'POST',
        url: '/getCollectionTop10',
        dataType: 'json',
        cache: false,
        data: [],
        success: function (data) {
            renderingRank(data, "collection_list")
        },
        error: function () {
            alert("获取收藏榜前10失败");
        }
    });
}

function getUpdateRankTop10() {
    $.ajax({
        type: 'POST',
        url: '/getUpdateRankTop10',
        dataType: 'json',
        cache: false,
        data: [],
        success: function (data) {
            renderingRank(data, "update_rankTop10_list")
        },
        error: function () {
            alert("获取更新榜前10失败");
        }
    });
}

function getAwardRankTop10() {
    $.ajax({
        type: 'POST',
        url: '/getAwardRankTop10',
        dataType: 'json',
        cache: false,
        data: [],
        success: function (data) {
            renderingRank(data, "award_rankTop10_list")
        },
        error: function () {
            alert("获取打赏榜前10失败");
        }
    });
}

function renderingRank(data, contentId) {
    let recomList = document.getElementById(contentId);
    let top1 = document.createElement("li");
    let div1 = document.createElement("div");
    let span1 = document.createElement("span");
    let p1 = document.createElement("p");
    let strong1 = document.createElement("strong");
    let span2 = document.createElement("span");
    let p2 = document.createElement("p");
    let div2 = document.createElement("div");
    let div3 = document.createElement("div");
    let img1 = document.createElement("img");
    top1.setAttribute("class", "first-book");
    div1.setAttribute("class", "f-book-box");
    span1.setAttribute("class", "the-num");
    span1.innerHTML = "NO.1";
    p1.innerHTML = data[0].novelName;
    p1.addEventListener('click', function () {
        window.open("bookInfo?novelUuid=" + data[0].novelUuid)
    })
    p1.style.cursor = 'pointer'
    strong1.innerHTML = data[0].score;
    switch (contentId) {
        case "month_ticket_rank": {
            span2.innerHTML = "月票最多";
            break;
        }
        case "recom_ticket_list": {
            span2.innerHTML = "推荐最多";
            break;
        }
        case "award_rankTop10_list": {
            span2.innerHTML = "打赏最多";
            break;
        }
        case "collection_list": {
            span2.innerHTML = "收藏最多";
            break;
        }
        case "update_rankTop10_list": {
            span2.innerHTML = "近期最肝";
            break;
        }
        default:
            span2.innerHTML = "人在追";

    }
    p2.setAttribute("class", "kind-author");
    p2.innerHTML = data[0].pCategory + "·" + data[0].writerName;
    div1.append(span1);
    div1.append(p1);
    div1.append(strong1);
    div1.append(span2);
    div1.append(p2);

    div2.setAttribute("class", "f-book-img")
    div3.setAttribute("class", "f-b-i-box")
    //img1.setAttribute("src","https://bookcover.yuewen.com/qdbimg/349573/1018027842/90");
    img1.src = "/file/getFile?fileId=" + data[0].novelUuid + "&size=90";
    img1.alt = "";
    div3.append(img1);
    div2.append(div3)
    top1.append(div1)
    top1.append(div2)
    recomList.append(top1);
    for (let i = 1, len = data.length; i < len; i++) {
        let rank = document.createElement("li");
        let rdiv1 = document.createElement("div");
        let rspan1 = document.createElement("span");
        let rdiv2 = document.createElement("div");
        let rspan2 = document.createElement("span");
        let rspan3 = document.createElement("span");
        rank.setAttribute("class", "rest-book")
        rdiv1.setAttribute("class", "rest-book-num")
        if (i == 1) {
            rspan1.setAttribute("class", "sec-num");
        }
        if (i == 2) {
            rspan1.setAttribute("class", "th-num");
        }
        rspan1.innerHTML = i + 1;
        rdiv1.append(rspan1);
        rdiv2.setAttribute("class", "rest-book-name");
        rspan2.innerHTML = data[i].novelName;
        rspan2.addEventListener('click', function () {
            window.open("bookInfo?novelUuid=" + data[0].novelUuid)
        })
        rspan2.style.cursor = 'pointer'
        rspan3.innerHTML = data[i].score;
        rdiv2.append(rspan2);
        rdiv2.append(rspan3);
        rank.append(rdiv1)
        rank.append(rdiv2)
        recomList.append(rank);
    }
}

function changeRotation(i) {
    let el = document.getElementById('rotation')
    switch (i) {
        case 1: {
            el.style.left = 0;
            break;
        }
        case 2: {
            el.style.left = '-100%';
            break;
        }
        case 3: {
            el.style.left = '-200%';
            break;
        }
        case 4: {
            el.style.left = '-300%';
            break;
        }
        case 5: {
            el.style.left = '-400%';
            break;
        }
    }
}

function initBook() {
    list[0].style.left = "-15%"
    list[1].style.left = "5%"
    list[2].style.left = "20%"
    list[3].style.left = width / 2 - cwidth / 2 + 'px'
    list[4].style.left = width * 0.8 - cwidth + 'px'
    list[5].style.left = width * 0.95 - cwidth + 'px'
    list[6].style.right = "-15%"
}

function openBookInfo(novelUuid) {
    window.open("bookInfo?novelUuid=" + novelUuid, "_blank");
}

function setBook(el, i, dir) {
    switch (i) {
        case 1: {
            if (dir === 'left') {
                el.style.transform = 'scale(0.4)'
                el.style.right = "-15%"
                el.style.left = ""

            } else {
                el.style.transform = 'scale(0.6)'
                el.style.left = "5%"
                el.style.opacity = 1
            }
            break;
        }
        case 2: {
            if (dir === 'left') {
                el.style.transform = 'scale(0.6)'
                el.style.left = "-15%"
                el.style.opacity = 0
            } else {
                el.style.transform = 'scale(0.8)'
                el.style.left = "20%"
                el.style.zIndex = 50
            }
            break;
        }
        case 3: {
            if (dir === 'left') {
                el.style.transform = 'scale(0.6)'
                el.style.left = "5%"
                el.style.zIndex = 1
            } else {
                el.style.transform = 'scale(1)'
                el.style.left = width / 2 - cwidth / 2 + 'px'
                el.style.zIndex = 100
            }
            break;
        }
        case 4: {
            if (dir === 'left') {
                el.style.transform = 'scale(0.8)'
                el.style.left = "20%"
                el.style.zIndex = 50
            } else {
                el.style.transform = 'scale(0.8)'
                el.style.left = width * 0.8 - cwidth + 'px'
                el.style.zIndex = 50
            }
            break;
        }
        case 5: {
            if (dir === 'left') {
                el.style.zIndex = 100
                el.style.transform = 'scale(1)'
                el.style.left = width / 2 - cwidth / 2 + 'px'

            } else {
                el.style.transform = 'scale(0.6)'
                el.style.left = "60%"
                el.style.zIndex = 1
            }
            break;
        }
        case 6: {
            if (dir === 'left') {
                el.style.transform = 'scale(0.8)'
                el.style.left = width * 0.8 - cwidth + 'px'
                el.style.zIndex = 50
            } else {
                el.style.transform = 'scale(0.4)'
                el.style.left = ""
                el.style.right = "5%"
                setTimeout(function () {
                    el.style.right = "-15%"
                }, 30)
                el.style.opacity = 0
            }
            break;
        }
        case 7: {
            if (dir === "left") {
                el.style.transform = 'scale(0.6)'
                el.style.right = "5%"
                setTimeout(() => {
                    el.style.right = ""
                    el.style.left = width * 0.95 - cwidth + 'px'
                }, 1000);
                el.style.zIndex = 1
                el.style.opacity = 1
            } else {
                el.style.left = "-15%"
                el.style.right = ""
                el.style.zIndex = 1
                el.style.transform = "scale(0.4)"
            }

            break;
        }
    }
}

function changeBook(dir) {
    if (flag === false) return
    flag = false
    let editorRecomTitle = document.getElementById("editorRecomTitle")
    let editorRecomIntro = document.getElementById("editorRecomIntro")
    let bookInfo = document.getElementById("bookInfo")
    if (dir === 'left') {
        list.forEach((item, i) => {
            setBook(item, i + 1, dir)
        })
        middle = (middle + 1) % 7
        let t = list.shift()
        list.push(t)
    } else {
        list.forEach((item, i) => {
            setBook(item, i + 1, dir)
        })
        middle = (middle + 7 - 1) % 7
        let t = list.pop()
        list.unshift(t)
    }
    editorRecomTitle.innerHTML = editorRecomData[middle].novelName;
    editorRecomIntro.innerHTML = editorRecomData[middle].intro;
    bookInfo.setAttribute("href", "bookInfo?novelUuid=" + editorRecomData[middle].novelUuid);
    setTimeout(() => {
        flag = true
    }, 1000);
}

window.onload = function () {
    initBook();
    getNewestStrongRecom();
    getNewestSanJiang();
    getLastWeekRecomTop10();
    getLastMonthTicketTop10();
    getCollectionTop10();
    getNewest5CoverRecom();
    getEditorRecom();
    getUpdateRankTop10();
    getAwardRankTop10();
    //getcount();
}