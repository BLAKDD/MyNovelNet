var left, right, totop, topLast, windowHeight, documentHeight, scrollTop, shelter2, rechargeClose, lbfPanelBody
var input, inputBox, readBody, mark, comment, bodyLeft, menuMark, close, release, reply, recharge, subscribe
var pageReply, pageReply, relInput, cancel, Rinput, Rrelease, Rlimit, Rpage, Rclose, shelter, shelter3
var set, setPage, colorItem, setClose, readFun, leftBox, rightBox, titleMark, rechargeBtn
var fontIem, bookText, plus, fontSize, minus, catalog, cataPage, cataClose
let monthTab, recTab, rewardTab, monthPopup, recPopup, rewardPopup
var FONT_SIZE = 18

let chapterUuid = document.getElementById('chapterUuid').value;
let novelUuid = document.getElementById('novelUuid').value;
let userUuid = getCookiebyName('userUuid');

const money = [
    100, 500, 1000, 2000, 10000, 50000, 100000, 1000000, 10000000
]

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

function initRewardList() {
    let rewardList = document.getElementById('rewardList')
    rewardList.innerHTML = ''
    let ul = document.createElement('ul')
    let rewardPriceList = new Array()
    let rewardCost = document.getElementById('rewardCost')
    let balance = document.getElementById('balance')
    let rewardCostNum
    money.forEach((el, n) => {
        let li = document.createElement('li')
        let pricediv = document.createElement('div')
        let price = document.createElement('p')
        let i = document.createElement('i')
        let cite = document.createElement('cite')
        rewardPriceList.push(li)
        li.addEventListener('click', function () {
            rewardCostNum = el
            rewardCost.innerHTML = el >= 10000 ? (el / 10000 + '万') : (el)
            rewardPriceList.forEach((eli, k) => {
                if (k == n) {
                    eli.setAttribute('class', 'act2')
                } else {
                    eli.setAttribute('class', '')
                }
            })
        })
        pricediv.setAttribute('class', 'price')
        price.setAttribute('class', 'lang')
        console.log(el)
        price.innerHTML = el >= 10000 ? (el / 10000 + '万点') : (el + '点')
        pricediv.append(price)
        if (el >= 10000) {
            let span = document.createElement('span')
            span.innerHTML = '赠' + el / 10000 + '张月票'
            pricediv.append(span)
        }
        li.append(pricediv)
        li.append(i)
        li.append(cite)
        ul.append(li)
    })
    rewardList.append(ul)
    document.getElementById('voteReward').addEventListener('click', function () {
        let bal = new Number(balance.innerHTML)
        if (bal < rewardCostNum) {
            //打赏钱不够，充值
            recharge.style.display = "block"
            shelter3.style.display = "block"
        } else {
            rewardImplement(rewardCostNum)
        }
    })
}

function init() {
    left = document.getElementById("left")
    right = document.getElementById("right")
    totop = document.getElementById("totop")
    topLast = document.getElementById("totop")
    right.setAttribute("class", "public-nav scroll-right right-nav")
    right.children[0].removeChild(topLast)
    windowHeight = document.compatMode == "CSS1Compat" ?
        document.documentElement.clientHeight :
        document.body.clientHeight;
    input = document.getElementById("input")
    inputBox = document.getElementById("inputBox")
    readBody = document.getElementById("readBody")
    mark = document.getElementById("mark")
    bodyLeft = document.getElementById("bodyLeft")
    comment = document.getElementById("comment")
    menuMark = document.getElementById("menuMark")
    close = document.getElementById("close")
    limit = document.getElementById("limit")
    release = document.getElementById("release")
    reply = document.getElementById("reply")
    pageReply = document.getElementById("pageReply")
    relInput = document.getElementById("relInput")
    cancel = document.getElementById("cancel")
    Rinput = document.getElementById("Rinput")
    Rrelease = document.getElementById("Rrelease")
    Rlimit = document.getElementById("Rlimit")
    Rpage = document.getElementById("Rpage")
    Rclose = document.getElementById("Rclose")
    shelter = document.getElementById("shelter")
    shelter2 = document.getElementById("shelter2")
    shelter3 = document.getElementById("shelter3")
    set = document.getElementById("set")
    setPage = document.getElementById("setPage")
    colorItem = document.getElementsByClassName("color-item")
    setClose = document.getElementById("setclose")
    readFun = document.getElementById("readFun")
    leftBox = document.getElementById("leftBox")
    rightBox = document.getElementById("rightBox")
    titleMark = document.getElementById("titleMark")
    fontIem = document.getElementsByClassName("font-item")
    bookText = document.getElementById("bookText")
    plus = document.getElementById("plus")
    fontSize = document.getElementById("fontSize")
    minus = document.getElementById("minus")
    catalog = document.getElementById("catalog")
    cataPage = document.getElementById("cataPage")
    cataClose = document.getElementById("cataClose")
    recharge = document.getElementById('recharge')
    rechargeClose = document.getElementById('rechargeClose')
    rechargeBtn = document.getElementById("rechargeBtn")
    subscribe = document.getElementById('subscribe')
    lbfPanelBody = document.getElementById('lbfPanelBody')
    monthTab = document.getElementById('monthTab')
    recTab = document.getElementById('recTab')
    rewardTab = document.getElementById('rewardTab')
    monthPopup = document.getElementById('monthPopup')
    recPopup = document.getElementById('recPopup')
    rewardPopup = document.getElementById('rewardPopup')
    setMenu()
    if (userUuid) {
        initLbfPanelBody()
    }
}

function setMenu() {
    right.style.position = "fixed"
    right.style.bottom = 0
    right.style.left = readBody.offsetLeft + readBody.offsetWidth + 8 + "px"
    left.style.top = readBody.offsetTop + "px"
    left.style.left = readBody.offsetLeft - 70 + "px"
}

function setTheme(id) {
    let bodyColor, readColor
    let fontColor = "#262626"
    if (id == "default") {
        bodyColor = "#f8efdc"
        readColor = "#f6f1e7"
    } else if (id == 0) {
        bodyColor = "rgba(245, 234, 204, .8)"
        readColor = "#f3e9c6"
    } else if (id == 1) {
        bodyColor = "rgba(230, 242, 230, .8)"
        readColor = "#e2eee2"
    } else if (id == 2) {
        bodyColor = "rgba(228, 241, 245, .8)"
        readColor = "#e2eff3"
    } else if (id == 3) {
        bodyColor = "rgba(245, 228, 228, .8)"
        readColor = "#f5e4e4"
    } else if (id == 4) {
        bodyColor = "rgba(224, 224, 224, .8)"
        readColor = "#dcdcdc "
    } else if (id == 5) {
        bodyColor = "#0f1112"
        fontColor = "#666"
        readColor = "#"
    }

    for (let i = 0; i < colorItem.length; i++) {
        if (colorItem[i].getAttribute("data-color") == id) {
            if (id == 5) {
                colorItem[i].style.border = "1px solid #e5e5e5"
                document.body.setAttribute("class", "black")
                Rpage.setAttribute("class", "reply-page read-black black-text")
                titleMark.setAttribute("class", "title-mark read-black")
                readBody.setAttribute("class", "read-body read-black")
                comment.setAttribute("class", "chap-com black-text")
                readFun.setAttribute("class", "read-fun read-black black-text")
                left.style.background = "#111 url('https://qidian.gtimg.com/qd/images/read.qidian.com/theme/theme_6_bg.45ad3.png') repeat"
                right.style.background = "#111 url('https://qidian.gtimg.com/qd/images/read.qidian.com/theme/theme_6_bg.45ad3.png') repeat"
                bodyLeft.setAttribute("class", "body-left black-text")
                leftBox.setAttribute("class", "black-act")
                rightBox.setAttribute("class", "black-act")
                setPage.setAttribute("class", "set black-text")
                cataPage.setAttribute("class", "catalog black-text")
            } else {
                colorItem[i].style.border = "1px solid #ed4259"
                document.body.setAttribute("class", "")
                titleMark.setAttribute("class", "title-mark")
                titleMark.style.backgroundColor = readColor
                Rpage.setAttribute("class", "reply-page")
                Rpage.style.backgroundColor = readColor
                comment.setAttribute("class", "chap-com")
                document.body.style.backgroundColor = bodyColor
                readBody.setAttribute("class", "read-body")
                readBody.style.backgroundColor = readColor
                readFun.setAttribute("class", "read-fun")
                readFun.style.backgroundColor = readColor
                left.style.background = ""
                left.style.backgroundColor = readColor
                right.style.background = ""
                right.style.backgroundColor = readColor
                bodyLeft.setAttribute("class", "body-left")
                leftBox.removeAttribute("class", "black-act")
                rightBox.removeAttribute("class", "black-act")
                setPage.setAttribute("class", "set")
                cataPage.setAttribute("class", "catalog")
            }
            colorItem[i].children[0].style.opacity = 1
        } else {
            colorItem[i].style.border = `1px solid #e5e5e5`
            colorItem[i].children[0].style.opacity = 0
        }
    }
}

function setFont(id) {
    if (id == 0) {
        fontIem[0].setAttribute("class", "font-item font-selected")
        fontIem[1].setAttribute("class", "font-item")
        fontIem[2].setAttribute("class", "font-item")
        bookText.style.fontFamily = "'Microsoft YaHei',PingFangSC-Regular,HelveticaNeue-Light,'Helvetica Neue Light',sans-serif"
    } else if (id == 1) {
        fontIem[0].setAttribute("class", "font-item")
        fontIem[1].setAttribute("class", "font-item font-selected")
        fontIem[2].setAttribute("class", "font-item")
        bookText.style.fontFamily = "PingFangSC-Regular,'-apple-system',Simsun"
    } else if (id == 2) {
        fontIem[0].setAttribute("class", "font-item")
        fontIem[1].setAttribute("class", "font-item")
        fontIem[2].setAttribute("class", "font-item font-selected")
        bookText.style.fontFamily = "Kaiti"
    }
}

function addEvent() {
    window.addEventListener("resize", function () {
        windowHeight = document.compatMode == "CSS1Compat" ?
            document.documentElement.clientHeight :
            document.body.clientHeight;
        documentHeight = Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);
    })

    window.addEventListener("scroll", function () {
        documentHeight = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight)
        scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop
        var scrollBottom = documentHeight - (windowHeight + scrollTop)
        if (scrollTop == 0)
            right.children[0].removeChild(topLast)
        else right.children[0].append(topLast)
        if (scrollTop > 60) {
            left.style.position = "fixed"
            left.style.left = readBody.offsetLeft - 70 + "px"
            left.style.top = 0
        } else {
            left.style.position = "absolute"
            left.style.top = readBody.offsetTop + 'px'
        }
        if (scrollBottom < 103) {
            console.log(1);
            right.style.position = "absolute"
            right.style.bottom = 103 + "px"
        } else {
            right.style.position = "fixed"
            right.style.bottom = 0
        }
    })

    totop.addEventListener("click", function () {
        scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop
        let clock = setInterval(() => {
            document.documentElement.scrollTop -= scrollTop / 30
            if (scrollTop == 0) clearInterval(clock)
        }, 1)
    })

    rechargeBtn.addEventListener("click", function () {
        let coins = document.getElementById('rechargeCoin')
        let coinCount = coins.value
        if (coinCount) {
            rechargeBookCoins(coinCount)
        } else {
            alert("尚未输入书币数量")
        }

    })

    input.addEventListener("click", function () {
        inputBox.style.height = "145px"
    })

    mark.addEventListener("click", function () {
        comment.style.display = "block"
        bodyLeft.style.borderRight = "1px solid #d8d8d8"
        readBody.style.width = "88%"
        setMenu()
    })

    menuMark.addEventListener("click", function () {
        comment.style.display = "block"
        bodyLeft.style.borderRight = "1px solid #d8d8d8"
        readBody.style.width = "88%"
        setMenu()
    })

    close.addEventListener("click", function () {
        comment.style.display = "none"
        bodyLeft.style.borderRight = "none"
        readBody.style.width = "800px"
        setMenu()
    })

    input.addEventListener("input", function () {
        if (input.value.length > 0) {
            release.style.opacity = 1
            release.style.cursor = "pointer"
        } else {
            release.style.opacity = 0.4
            release.style.cursor = "default"
        }
        limit.innerHTML = 150 - input.value.length + "/150"
    })

    reply.addEventListener("click", function () {
        Rpage.style.display = "block"
        shelter.style.display = "block"
    })

    pageReply.addEventListener("click", function () {
        relInput.style.display = "block"
    })

    cancel.addEventListener("click", function () {
        relInput.style.display = "none"
    })

    Rinput.addEventListener("input", function () {
        if (Rinput.value.length > 0) {
            Rrelease.style.opacity = 1
            Rrelease.style.cursor = "pointer"
        } else {
            Rrelease.style.opacity = 0.4
            Rrelease.style.cursor = "default"
        }
        Rlimit.innerHTML = 150 - Rinput.value.length + "/150"
    })

    Rclose.addEventListener("click", function () {
        Rpage.style.display = "none"
        shelter.style.display = "none"
    })

    rechargeClose.addEventListener("click", function () {
        recharge.style.display = "none"
        shelter3.style.display = "none"
    })

    document.getElementById('subscribeClose').addEventListener("click", function () {
        subscribe.style.display = "none"
        shelter.style.display = "none"
    })

    document.getElementById('lbfPanelBodyClose').addEventListener("click", function () {
        lbfPanelBody.style.display = "none"
        shelter.style.display = "none"
    })

    monthTab.addEventListener("click", function () {
        changePanel(1)
    })

    recTab.addEventListener("click", function () {
        changePanel(2)
    })

    rewardTab.addEventListener("click", function () {
        changePanel(3)
    })


    set.addEventListener("click", function () {
        set.setAttribute("class", "act")
        setPage.style.display = "block"
        shelter2.style.display = "block"
        if (catalog.getAttribute("class")) {
            catalog.removeAttribute("class")
            cataPage.style.display = "none"
        }
    })

    setClose.addEventListener("click", function () {
        setPage.style.display = "none"
        shelter2.style.display = "none"
        set.setAttribute("class", "")
    })

    catalog.addEventListener("click", function () {
        cataPage.style.display = "block"
        catalog.setAttribute("class", "act")
        shelter2.style.display = "block"
        if (set.getAttribute("class")) {
            set.removeAttribute("class")
            setPage.style.display = "none"
        }
    })

    cataClose.addEventListener("click", function () {
        cataPage.style.display = "none"
        shelter2.style.display = "none"
        catalog.removeAttribute("class")
    })

    plus.addEventListener("click", function () {
        if (FONT_SIZE == 36) return
        FONT_SIZE += 2
        bookText.style.fontSize = FONT_SIZE + "px"
        fontSize.innerHTML = FONT_SIZE
    })

    minus.addEventListener("click", function () {
        if (FONT_SIZE == 12) return
        FONT_SIZE -= 2
        bookText.style.fontSize = FONT_SIZE + "px"
        fontSize.innerHTML = FONT_SIZE
    })

    for (let i = 0; i < colorItem.length; i++)
        colorItem[i].addEventListener("click", function () {
            setTheme(colorItem[i].getAttribute("data-color"))
        })


    for (let i = 0; i < fontIem.length; i++)
        fontIem[i].addEventListener("click", function () {
            setFont(fontIem[i].getAttribute("data-font"))
        })

}

function openlbfPanel(n) {
    if (userUuid) {
        lbfPanelBody.style.display = 'block'
        shelter.style.display = 'block'
        changePanel(n)
    } else {
        loginDialog.showModal()
    }

}

function changePanel(n) {
    monthTab.setAttribute('class', 'lang')
    monthPopup.style.display = 'none'
    recTab.setAttribute('class', 'lang')
    recPopup.style.display = 'none'
    rewardTab.setAttribute('class', 'lang')
    rewardPopup.style.display = 'none'
    if (n == 1) {
        monthTab.setAttribute('class', 'lang act2')
        monthPopup.style.display = 'block'
    } else if (n == 2) {
        recTab.setAttribute('class', 'lang act2')
        recPopup.style.display = 'block'
    } else {
        rewardTab.setAttribute('class', 'lang act2')
        rewardPopup.style.display = 'block'
    }
}

function initReadPageInfo() {
    $.ajax({
        type: 'POST',
        url: '/book/getReadPageInfo',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'novelUuid',
            value: novelUuid
        }, {
            name: 'chapterUuid',
            value: chapterUuid
        }, {
            name: 'userUuid',
            value: userUuid
        }],
        success: function (data) {
            document.getElementById('pCategory').innerHTML = data.pCategory
            document.getElementById('category').innerHTML = data.category
            document.getElementById('novelNameUp').innerHTML = data.novelName
            document.getElementById('chapterName').innerHTML = data.chapterName
            document.getElementById('title').innerHTML = data.chapterName
            document.getElementById('novelNamedown').innerHTML = data.novelName
            document.getElementById('writerName').innerHTML = data.writerName
            document.getElementById('wordCount').innerHTML = data.chapterWordCount
            document.getElementById('updateTime').innerHTML = data.updateTime
            if (userUuid) {
                if (data.ifInbookstore == 1) {
                    document.getElementById('bookShelf').style.pointerEvents = "none"
                    document.getElementById('bookShelfContent').innerHTML = '已在'
                }
            } else {
                document.getElementById('bookShelf').style.pointerEvents = "none"
            }
            if (data.ifVip == 1) {
                if (data.ifBuy == 1) {
                    initChapterContext()
                } else {
                    //已登录提醒购买，未登录提醒登录
                    if (userUuid) {
                        //查查询余额，弹出窗口判断订阅，自动订阅，弹出充值
                        searchBookCoin(data.cost)
                    } else {
                        document.getElementById('loginDialog').showModal()
                    }
                }
            } else {
                initChapterContext()
            }
            //data.rank 获得上一章和下一章的chapterUuid
            initChangeChapterButton(data.chapterRank)
        },
        error: function () {
            alert("章节相关属性加载失败");
        }
    });
}

function initChapterContext() {
    $.ajax({
        type: 'POST',
        url: '/book/getChapterContext',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'chapterUuid',
            value: chapterUuid
        }],
        success: function (data) {
            bookText.innerHTML = '';
            let chapterContext = JSON.parse(data.context)
            let postscript = JSON.parse(data.postscript)
            chapterContext.forEach(el => {
                let p = document.createElement('p')
                p.innerHTML = el
                bookText.append(p)
            })
            if (postscript) {
                console.log(111)
                let p = document.createElement('p')
                p.innerHTML = '--------ps---------'
                bookText.append(p)
                postscript.forEach(el => {
                    let p = document.createElement('p')
                    p.innerHTML = el
                    bookText.append(p)
                })
            }
            if (userUuid) {
                updateReadProgress()
            }
        },
        error: function () {
            alert("章节内容加载失败");
        }
    });
}

function updateReadProgress() {
    $.ajax({
        type: 'POST',
        url: '/book/updateReadProgress',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'novelUuid',
            value: novelUuid
        }, {
            name: 'userUuid',
            value: userUuid
        }, {
            name: 'chapterUuid',
            value: chapterUuid
        }],
        success: function (data) {
        },
        error: function () {
            alert("更新阅读进度失败");
        }
    });
}

function initChangeChapterButton(chapterRank) {
    $.ajax({
        type: 'POST',
        url: '/book/getNearChapterUuid',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'novelUuid',
            value: novelUuid
        }, {
            name: 'chapterRank',
            value: chapterRank
        }],
        success: function (data) {
            let gotoLastChapter = document.getElementById('gotoLastChapter')
            let gotoNextChapter = document.getElementById('gotoNextChapter')
            if (data.lastChapterUuid) {
                gotoLastChapter.href = "/read?novelUuid=" + novelUuid + "&chapterUuid=" + data.lastChapterUuid;
            } else {
                gotoLastChapter.onclick = function () {
                    alert('已是最先章节')
                }
            }
            if (data.nextChapterUuid) {
                gotoNextChapter.href = "/read?novelUuid=" + novelUuid + "&chapterUuid=" + data.nextChapterUuid;
            } else {
                gotoNextChapter.onclick = function () {
                    alert('已是最新章节')
                }
            }
        },
        error: function () {
            alert("前后章节uuid获取失败");
        }
    });
}


function initCatalogList() {
    $.ajax({
        type: 'POST',
        url: '/book/getEasyCatalog',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'novelUuid',
            value: novelUuid
        }],
        success: function (data) {
            let catalogList = document.getElementById('catalogList')
            for (let i = 0; i < data.length; i++) {
                let li = document.createElement('li')
                let a = document.createElement('a')
                a.innerHTML = data[i].chapterName
                a.href = "/read?novelUuid=" + novelUuid + "&chapterUuid=" + data[i].chapterUuid;
                li.append(a)
                catalogList.append(li)
            }
        },
        error: function () {
            alert("初始化简易目录失败");
        }
    });
}

function rechargeBookCoins(bookCoin) {
    $.ajax({
        type: 'POST',
        url: '/recharge',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'userUuid',
            value: userUuid
        }, {
            name: 'bookCoin',
            value: bookCoin
        }],
        success: function (data) {
            if (data == 0) {
                alert("充值失败")
            } else {
                alert("充值成功")
                shelter3.style.display = 'none'
                recharge.style.display = 'none'
                location.reload()
            }
        },
        error: function () {
            alert("充值请求出错");
        }
    });
}

function searchBookCoin(cost) {
    $.ajax({
        type: 'POST',
        url: '/getReadReader',
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
            //是否自动订阅 * 是否有充足的余额
            //没钱，弹充值
            // 自动，有钱=>扣钱加载内容
            // 手动，弹订阅窗口=>订阅->扣钱加载内容
            //              =>自动订阅，扣钱加载内容，将自动订阅写入数据库if ()
            if (data.bookCoins < cost) {
                recharge.style.display = "block"
                shelter3.style.display = "block"
            } else {
                if (data.ifAutoOrder == 1) {
                    subscribeThisChapter(cost)
                } else {
                    subscribe.style.display = "block"
                    shelter.style.display = "block"
                    document.getElementById('subscribeBtn').addEventListener("click", function () {
                        subscribeThisChapter(cost)
                    })

                    document.getElementById('autoSubscribeBtn').addEventListener("click", function () {
                        chooseAutoSubscribeThisNovel(cost)
                    })
                }
            }
        },
        error: function () {
            alert("查询账户余额出错");
        }
    });
}


function subscribeThisChapter(cost) {
    $.ajax({
        type: 'POST',
        url: '/subscribeChapter',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'userUuid',
            value: userUuid
        }, {
            name: 'novelUuid',
            value: novelUuid
        }, {
            name: 'chapterUuid',
            value: chapterUuid
        }, {
            name: 'bookCoin',
            value: cost
        }],
        success: function (data) {
            if (data == 0) {
                alert("支付失败")
            } else {
                subscribe.style.display = 'none'
                shelter.style.display = 'none'
                initChapterContext()
            }
        },
        error: function () {
            alert("支付请求出错");
        }
    });
}

function chooseAutoSubscribeThisNovel(cost) {
    $.ajax({
        type: 'POST',
        url: '/book/updateIfAutoSubscribe',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'userUuid',
            value: userUuid
        }, {
            name: 'novelUuid',
            value: novelUuid
        }, {
            name: 'ifAutoOrder',
            value: 1
        }],
        success: function (data) {
            if (data == 0) {
                alert('开启自动订阅失败')
            } else {
                subscribeThisChapter(cost)
            }
        },
        error: function () {
            alert("自动订阅请求出错");
        }
    });
}

function initLbfPanelBody() {
    $.ajax({
        type: 'POST',
        url: '/getReader',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'userUuid',
            value: userUuid
        }],
        success: function (data) {
            let monthTickBalance = document.getElementById('monthTickBalance')
            let monthTicCount = document.getElementById('monthTicCount')
            let voteMonthTicket = document.getElementById('voteMonthTicket')
            monthTickBalance.innerHTML = data.userMonthTicket
            monthTicCount.setAttribute('max', data.userMonthTicket)
            voteMonthTicket.addEventListener('click', function () {
                let num = new Number(monthTickBalance.innerHTML)
                if (num != 0) {
                    voteMonthTicketImpl(monthTicCount.value)
                } else {
                    alert('没有月票')
                }
            })

            let recTickBalance = document.getElementById('recTickBalance')
            let recNum = document.getElementById('recNum')
            let voteRecTicket = document.getElementById('voteRecTicket')
            recTickBalance.innerHTML = data.userRecomTicket
            recNum.setAttribute('max', data.userRecomTicket)
            voteRecTicket.addEventListener('click', function () {
                let num = new Number(recTickBalance.innerHTML)
                if (num != 0) {
                    voteRecTicketImpl(recNum.value)
                } else {
                    alert('没有推荐票!')
                }
            })
            document.getElementById('balance').innerHTML = data.bookCoin
            initRewardList()
        },
        error: function () {
            alert("获取用户数据出错");
        }
    });


}

function rewardImplement(rewardNum) {
    //打赏操作
    $.ajax({
        type: 'POST',
        url: '/book/rewardNovel',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'userUuid',
            value: userUuid
        }, {
            name: 'novelUuid',
            value: novelUuid
        }, {
            name: 'rewardNum',
            value: rewardNum
        }],
        success: function (data) {
            if (data.status == 0) {
                alert(data.content)
                //重新加载div

            } else {
                alert(data.content)
                lbfPanelBody.style.display = "none"
                shelter.style.display = "none"
                initLbfPanelBody()
            }
        },
        error: function () {
            alert("打赏操作出错");
        }
    });
}

function voteMonthTicketImpl(ticketCount) {
    //投月票操作
    $.ajax({
        type: 'POST',
        url: '/book/voteMonthTicket',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'userUuid',
            value: userUuid
        }, {
            name: 'novelUuid',
            value: novelUuid
        }, {
            name: 'ticketNum',
            value: ticketCount
        }],
        success: function (data) {
            if (data.status == 0) {
                alert(data.content)
                //重新加载div
                initLbfPanelBody()
            } else {
                alert(data.content)
                let monthTickBalance = document.getElementById('monthTickBalance')
                let monthTicCount = document.getElementById('monthTicCount')
                let balance = new Number(monthTickBalance.innerHTML)
                monthTickBalance.innerHTML = balance - ticketCount
                monthTicCount.value = 1
                monthTicCount.setAttribute("max", balance - ticketCount)
                lbfPanelBody.style.display = "none"
                shelter.style.display = "none"
            }
        },
        error: function () {
            alert("投月票操作出错");
        }
    });
}

function voteRecTicketImpl(ticketCount) {
    //投推荐票操作
    $.ajax({
        type: 'POST',
        url: '/book/voteRecTicket',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'userUuid',
            value: userUuid
        }, {
            name: 'novelUuid',
            value: novelUuid
        }, {
            name: 'ticketNum',
            value: ticketCount
        }],
        success: function (data) {
            if (data.status == 0) {
                alert(data.content)
                //重新加载div
                initLbfPanelBody()
            } else {
                alert(data.content)
                let recTickBalance = document.getElementById('recTickBalance')
                let recNum = document.getElementById('recNum')
                let balance = new Number(recTickBalance.innerHTML)
                recTickBalance.innerHTML = balance - ticketCount
                recNum.value = 1
                recNum.setAttribute("max", balance - ticketCount)
                lbfPanelBody.style.display = "none"
                shelter.style.display = "none"
            }
        },
        error: function () {
            alert("投推荐票操作出错");
        }
    });
}

init()
addEvent()
initReadPageInfo()
initCatalogList()