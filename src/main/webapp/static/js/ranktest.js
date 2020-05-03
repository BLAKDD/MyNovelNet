function adddailyrank() {
    let rankname = $("#rankname").val();
    let value = $("#uuid").val();
    let score = $("#score").val();
    $.ajax({
        type: 'POST',
        url: '/rank/addrankbyKVS',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'value',
            value: value
        }, {
            name: 'score',
            value: score
        }],
        success: function (result) {
            alert(result);
        },
        error: function () {
            alert("失败");
        }
    });
}

function addtorank() {
    let value = $("#uuid").val();
    let score = $("#score").val();
    $.ajax({
        type: 'POST',
        url: 'http://127.0.0.1:8080/rank/addrankbyKVS',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'value',
            value: value
        }, {
            name: 'score',
            value: score
        }],
        success: function (result) {
            alert(result);
        },
        error: function () {
            alert("失败");
        }
    });
}

function gettop2() {
    $.ajax({
        type: 'POST',
        url: 'http://127.0.0.1:8080/rank/gettopn',
        dataType: 'json',
        cache: false,
        data: [{
            name: 'n',
            value: 2
        }],
        success: function (data) {
            let list1 = [
                document.getElementById('rank1'),
                document.getElementById('rank2'),
            ]
            let n = 0;
            let rant = document.getElementById("testrankId");
            for (let i = 0, len = data.length; i < len; i++) {
                let cate = document.createElement("li");
                let a1 = document.createElement("a");
                let a2 = document.createElement("a");
                let a3 = document.createElement("a");
                a1.setAttribute("href", "javascript:;");
                a1.innerHTML = data[i].rank;
                a2.setAttribute("href", "javascript:;");
                a2.innerHTML = data[i].bookUuid;
                a3.setAttribute("href", "javascript:;");
                a3.setAttribute("class", "author");
                a3.innerHTML = data[i].score;
                cate.append(a1);
                cate.append(a2);
                cate.append(a3);
                rant.append(cate);
                list1[i].innerHTML = data[i].rank;
            }
        },
        error: function () {
            alert("出错了111");
        }
    });
}