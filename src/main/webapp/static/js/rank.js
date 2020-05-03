var time = new Date();

function initUpdateTime() {
    let updateTime = document.getElementById("update_time")
    updateTime.innerHTML = time.toLocaleString() + " 更新"
}

function getThisWeekRecomTop10() {
    let day = time.getDay() || 7;
    let mondayDate = new Date(time.getFullYear(), time.getMonth(), time.getDate() + 1 - day);
    let mymonth = mondayDate.getMonth() + 1;
    let myweekday = mondayDate.getDate();
    if (mymonth < 10) {
        mymonth = "0" + mymonth;
    }
    if (myweekday < 10) {
        myweekday = "0" + myweekday;
    }
    let monday = mondayDate.getFullYear() + mymonth + myweekday;
    let rankName = "all_week_recom" + monday;
    $.ajax({
        type: 'POST',
        url: '/getRankTop10?rankName=' + rankName,
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

function getThisMonthTicketTop10() {
    let mymonth = time.getMonth() + 1;
    if (mymonth < 10) {
        mymonth = "0" + mymonth;
    }
    let thisMonth = time.getFullYear() + mymonth;
    let rankName = "all_monthticket" + thisMonth;
    $.ajax({
        type: 'POST',
        url: '/getRankTop10?rankName=' + rankName,
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

function getSellRankTop10() {
    $.ajax({
        type: 'POST',
        url: '/getSellRankTop10',
        dataType: 'json',
        cache: false,
        data: [],
        success: function (data) {
            renderingRank(data, "yesterday_sell_rankTop10_list")
        },
        error: function () {
            alert("获取24小时热销榜前10失败");
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
        case "yesterday_sell_rankTop10_list": {
            span2.innerHTML = "昨日最热";
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

initUpdateTime()
getThisWeekRecomTop10();
getThisMonthTicketTop10();
getCollectionTop10();
getUpdateRankTop10();
getAwardRankTop10();
getSellRankTop10();
window.onload = function () {


}