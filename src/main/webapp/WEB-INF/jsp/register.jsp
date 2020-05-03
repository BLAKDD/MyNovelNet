<%--
  Created by IntelliJ IDEA.
  User: BLAKD
  Date: 2020/4/17
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/register.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/md5.js"></script>
    <script type="text/javascript">
        let p3 = document.getElementById("p3")

        function register() {
            let userId = $("#userId").val();
            let username = $("#username").val();
            let password = $("#password").val();
            let confirmPassword = $("#confirmPassword").val();
            let sex = $("input[name='sex']:checked").val();

            if (userId == '') {
                alert("账号不能为空")
                return;
            }
            if (username == '') {
                alert("用户名不能为空")
                return;
            }
            if (password == '') {
                alert("密码不能为空")
                return;
            }
            if (confirmPassword == '') {
                alert("密码尚未验证相同")
                return;
            }
            if (password != confirmPassword) {
                alert("密码尚未验证相同")
                return;
            }
            password = $.md5(password);
            $.ajax({
                type: 'POST',
                url: '/login/register',
                dataType: 'json',
                cache: false,
                data: [{
                    name: 'userId',
                    value: userId
                }, {
                    name: 'username',
                    value: username
                }, {
                    name: 'password',
                    value: password
                }, {
                    name: 'sex',
                    value: sex
                }],
                success: function (data) {
                    if (data.status == 1) {
                        alert(data.content + "页面即将关闭")
                        window.opener = null;
                        window.open('', '_self');
                        window.close();
                    } else {
                        alert("data.content")
                    }
                },
                error: function () {
                    alert("登录请求出错");
                }
            });
        }

        function passwordChanged() {
            let password = $("#password").val();
            let confirmPassword = $("#confirmPassword").val();
            if (password != '' && confirmPassword != '') {
                if (password != confirmPassword) {
                    document.getElementById("p3").style.display = "block"
                } else {
                    document.getElementById("p3").style.display = "none"
                }
            }
        }
    </script>
</head>
<body>
<div class="registerDiv">
    <ul class="registerUl">
        <h2 class="registerTitle">欢迎注册</h2>
        <table style="margin: auto">
            <tr>
                <td><label class="fl">账号</label></td>
                <td><input type="text" id="userId"/></td>
                <td></td>
            </tr>
            <tr>
                <td><label class="fl">用户名</label></td>
                <td><input type="text" id="username"/></td>
                <td></td>
            </tr>
            <tr>
                <td><label class="fl">密码</label></td>
                <td><input type="password" id="password" onchange="passwordChanged()"/></td>
            </tr>
            <tr>
                <td><label class="fl">确认密码</label></td>
                <td><input type="password" id="confirmPassword" onchange="passwordChanged()"/></td>
                <td><p id="p3" style="font-size: 12px; display: none">请保持两次密码一致</p>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <label><input type="radio" name="sex" value="1" checked="checked"/>男</label>
                    <label><input type="radio" name="sex" value="2"/>女</label>
                </td>
            </tr>
        </table>
        <li>
            <a id="confirmLoginBtn" class="registerBtn" href="javascript:" onclick="register()">注册</a>
        </li>
    </ul>
</div>
</body>
</html>
