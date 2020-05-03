var loginDialog = document.getElementById("loginDialog")

function loginBtnClick() {
    loginDialog.showModal()
}

function cofirmLogin() {
    let userId = $("#userId").val();
    let password = $("#password").val();
    password = $.md5(password);
    $.ajax({
        type: 'POST',
        url: '/login/comfirm?userId=' + userId + '&password=' + password,
        dataType: 'json',
        cache: false,
        data: [],
        success: function (data) {
            if (data.status == 1) {
                loginDialog.close()
                // document.getElementById("needLogin").style.display = "none";//隐藏
                // document.getElementById("alreadyLogin").style.display = "block";//显示
                // let username = document.getElementById("user-name")
                // username.innerHTML = data.content
                // if (getCookiebyName("identity") == 2) {
                //     if (document.title == "首页") {
                //         document.getElementById("writerPageId").style.display = "block";//显示
                //     }
                // }
            } else if (data.status == 2) {
                alert("用户名密码错误")
            } else {
                alert("用户名不存在")
            }
            location.reload()
        },
        error: function () {
            alert("登录请求出错");
        }
    });
}

function autoLogin() {
    let userId = getCookiebyName("userId");
    let password = getCookiebyName("password");
    if (userId != '' && password != '') {
        document.getElementById("needLogin").style.display = "none";//隐藏
        document.getElementById("alreadyLogin").style.display = "block";//显示
        let username = document.getElementById("user-name")
        username.innerHTML = getCookiebyName("username")
        if (getCookiebyName("identity") == 2) {
            if (document.title == "首页") {
                document.getElementById("writerPageId").style.display = "block";//显示
            }
        }
    }
}

function exitLogin() {
    document.getElementById("needLogin").style.display = "block";
    document.getElementById("alreadyLogin").style.display = "none";
    if (document.title == "首页") {
        document.getElementById("writerPageId").style.display = "none";
    }
    if (getCookiebyName("userId")) {
        delCookie("userId")
        console.log(1)
    }
    delCookie("userId")
    delCookie("userUuid")
    delCookie("username")
    delCookie("password")
    delCookie("identity")
    window.location.reload()
}

function delCookie(name) {
    document.cookie = name + "=''; expires=Thu, 01 Jan 1970 00:00:00 GMT";
}

function closeLoginDialog() {
    $("#userId").val('')
    $("#password").val('')
    loginDialog.close()
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

autoLogin()
