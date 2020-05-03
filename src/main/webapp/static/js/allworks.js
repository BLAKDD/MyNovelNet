var tags = document.getElementsByClassName("tags")
var box = document.getElementById("selected")
let allTag = {}
var temp = {
    tl: []
}
var category, states, ifVip, minWordCount, maxWordCount

function printData() {
    console.log('category:' + category + " states:" + states + ' ifVip' + ifVip + ' minWordCount:' + minWordCount + ' maxWordCount:' + maxWordCount)
}

var currentTags = new Proxy(temp.tl, {
    set(target, key, vl) {
        let t = target[key]
        Reflect.set(target, key, vl);
        if (typeof target[key] == "object") {
            if (typeof t != "object")
                createNode(vl, true)
        } else if (typeof target[key] == "number")
            console.log(1);
        return true
    }
})

function init() {
    var type = ""
    for (let i = 0; i < tags.length; i++) {
        if (type != tags[i].getAttribute("type")) {
            type = tags[i].getAttribute("type")
            allTag[type] = new Array()
        }
        allTag[type].push(tags[i])
    }
    for (let index in allTag) {
        set(index, allTag[index][0], false)
    }
    createNode({
        kind: "all",
        text: "全部"
    }, false)
}


function set(kind, el, ifcreate) {
    allTag[kind].forEach(item => {
        if (el == item) {
            switch (kind) {
                case 'categories': {
                    category = item.dataset.category
                    break;
                }
                case 'status': {
                    states = item.dataset.states
                    break;
                }
                case 'ifVip': {
                    ifVip = item.dataset.ifvip
                    break;
                }
                case 'num': {
                    switch (item.dataset.count) {
                        case '0': {
                            minWordCount = 0
                            maxWordCount = 0
                            break;
                        }
                        case '1': {
                            minWordCount = 0
                            maxWordCount = 300000
                            break;
                        }
                        case '2': {
                            minWordCount = 300000
                            maxWordCount = 500000
                            break;
                        }
                        case '3': {
                            minWordCount = 500000
                            maxWordCount = 1000000
                            break;
                        }
                        case '4': {
                            minWordCount = 1000000
                            maxWordCount = 2000000
                            break;
                        }
                        case '5': {
                            minWordCount = 2000000
                            maxWordCount = 0
                            break;
                        }
                    }
                    break;
                }
            }
            item.setAttribute("class", "s-selected")
            if (ifcreate) {
                let flag = true
                console.log(currentTags)
                for (let i = 0; i < currentTags.length; i++) {
                    if (currentTags[i].kind == kind) {
                        for (let j = 0; j < box.children.length; j++)
                            if (box.children[j].getAttribute("type") == kind) {
                                currentTags[i].text = item.innerHTML
                                flag = false
                                changeNode(kind, item.innerHTML)
                                break
                            }
                    }
                }
                if (flag && el.innerText != '全部') {
                    currentTags.push({
                        kind: item.getAttribute("type"),
                        text: item.innerHTML
                    })
                }
            }
        } else {
            if (item.getAttribute("class")) {
                item.setAttribute("class", 'tags')
            }

        }

    })
}


function createNode(vl, flag) {
    for (let i = 0; i < box.children.length; i++)
        if (box.children[i].innerHTML == "全部" && vl.text == "全部") return
    if (box.children.length >= 1 && vl.text == "全部") return
    let li = document.createElement("li")
    let a = document.createElement("a")
    li.setAttribute("class", "selected-tags")
    li.setAttribute("type", vl.kind)
    a.innerHTML = vl.text
    a.setAttribute("href", "javascript:void(0);")
    a.setAttribute("type", vl.kind)
    if (vl.text != '全部') {
        let i = document.createElement("i")
        i.setAttribute("class", "iconfont")
        i.innerHTML = "&#xe61f;"
        i.addEventListener("click", () => [
            deleteNode(i.parentNode.parentNode)
        ])
        a.append(i)
    }
    li.append(a)
    box.append(li)
    if (box.children.length == 2 && box.children[0].children[0].innerHTML == "全部") {
        deleteNode(box.children[0])
        console.log(1);
    }
}

function changeNode(kind, vl) {
    let child = box.children
    for (let i = 0; i < child.length; i++) {
        if (child[i].getAttribute("type") == kind) {
            console.log(kind)
            if (vl == "全部" && child.length > 1)
                deleteNode(child[i])
            else if (vl == "全部" && child.length == 1) {
                if (currentTags.length == 1) {
                    deleteNode(child[i])
                    createNode({
                        kind: "all",
                        text: "全部"
                    }, false)
                    currentTags.pop()
                } else {
                    return
                }
            } else {
                console.log(child[i])///[\u4E00-\u9FA5]+/
                console.log(child[i].children[0].innerHTML)
                child[i].children[0].innerHTML = child[i].children[0].innerHTML.replace(/[^<]+/, vl)
                if (child.length == 1 && vl == "全部") {
                    console.log(child[i].children[0].innerHTML)
                    child[i].children[0].removeChild(child[i].children[0].children[0])
                } else if (child[i].children[0].children[0])
                    child[i].children[0].children[0].addEventListener("click", () => {
                        deleteNode(child[i].children[0].children[0].parentNode.parentNode)
                    })
            }
            return
        }
    }
}


function deleteNode(child) {
    let t = -1
    if (child.getAttribute("type") == "all") {
        box.removeChild(child)
        return
    }
    for (let i = 0; i < currentTags.length; i++) {
        if (currentTags[i].kind == child.getAttribute("type")) {
            t = i
            break
        }
    }
    if (t != -1) {
        currentTags.splice(t, 1)
        box.removeChild(child)
        set(child.getAttribute("type"), allTag[child.getAttribute("type")][0], false)
    }
    if (box.children.length == 0) {
        createNode({
            kind: "all",
            text: "全部"
        }, false)
    }
}

function addEvent() {
    for (item in allTag) {
        allTag[item].forEach(element => {
            element.addEventListener("click", () => {
                set(element.getAttribute("type"), element, true)
                initBookList()
                //printData()
            })
        });
    }

}

function initBookList() {
    $.ajax({
        type: 'POST',
        url: '/book/getAllWorksByFilter',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'category',
            value: category
        }, {
            name: 'state',
            value: states
        }, {
            name: 'ifVip',
            value: ifVip
        }, {
            name: 'minWordCount',
            value: minWordCount
        }, {
            name: 'maxWordCount',
            value: maxWordCount
        }],
        success: function (data) {
            let bookList = document.getElementById('bookList')
            bookList.innerHTML = ''
            for (let i = 0; i < data.length; i++) {
                let content = document.createElement('li')
                let imgDiv = document.createElement('div')
                let imga = document.createElement('a')
                let img = document.createElement('img')
                imgDiv.setAttribute("class", 'b-img')
                imga.setAttribute('href', "bookInfo?novelUuid=" + data[i].novelUuid)
                img.src = "/file/getFile?fileId=" + data[i].novelUuid + "&size=150"
                img.alt = ''
                imga.append(img)
                imgDiv.append(imga)
                content.append(imgDiv)
                let information = document.createElement('div')
                let bookName = document.createElement('a')
                let authorDiv = document.createElement('div')
                let writerName = document.createElement('span')
                let em1 = document.createElement('em')
                let category = document.createElement('span')
                let em2 = document.createElement('em')
                let state = document.createElement('span')
                let intro = document.createElement('p')
                let wordCount = document.createElement('p')
                information.setAttribute("class", 'b-det')
                bookName.setAttribute("class", 'b-name')
                bookName.setAttribute('href', "bookInfo?novelUuid=" + data[i].novelUuid)
                bookName.innerHTML = data[i].novelName
                authorDiv.setAttribute("class", 'author')
                writerName.innerHTML = data[i].writerName
                em1.innerHTML = ' | '
                category.innerHTML = data[i].pCategory + '·' + data[i].category
                em2.innerHTML = ' | '
                state.innerHTML = data[i].state = 1 ? '连载' : '完本'
                authorDiv.appendChild(writerName)
                authorDiv.appendChild(em1)
                authorDiv.appendChild(category)
                authorDiv.appendChild(em2)
                authorDiv.appendChild(state)
                intro.setAttribute("class", 'b-intro')
                intro.innerHTML = data[i].intro
                wordCount.setAttribute("class", 'b-num')
                wordCount.innerHTML = (data[i].wordCount / 10000).toFixed(2) + "万字"
                information.append(bookName)
                information.append(authorDiv)
                information.append(intro)
                information.append(wordCount)
                content.append(information)
                bookList.append(content)
            }
        },
        error: function () {
            alert("获取书架信息出错");
        }
    });
}


init()
addEvent()
//printData()
initBookList()
