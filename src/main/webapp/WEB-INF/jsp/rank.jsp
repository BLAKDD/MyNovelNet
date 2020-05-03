<%--
  Created by IntelliJ IDEA.
  User: BLAKD
  Date: 2020/4/10
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>排行榜</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Autocomplate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Dropdown.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/demo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/allworks.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/myCss.css">

    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/md5.js"></script>
</head>

<body>
<div class="outer-wrap">
    <div class="navigater">
        <div class="login-box fr">
            <div id="alreadyLogin" class="sign-in hidden">
                <span class="login">你好，</span>
                <a class="login" style="color: #1a1a1a" id="user-name" href="/self" target="_blank"></a>
                <em class="login">|</em>
                <a id="exit-btn" class="login" href="javascript:" onclick="exitLogin()">退出</a>
            </div>
            <div id="needLogin" style="float: right;">
                <a id="loginBtn" class="login" href="javascript:" onclick="loginBtnClick()">登录</a>
                <em class="login">|</em>
                <a id="reg-btn" class="login" style="margin-right: 10px;" href="/register" target="_blank">&nbsp;注册</a>
            </div>
        </div>
    </div>
    <dialog class="loginDialog" id="loginDialog">
        <div class="loginDiv">
            <ul>
                <h2 class="loginTitle">用户登录</h2>
                <li><label>账号</label><input type="text" id="userId"/></li>
                <li><label>密码</label><input type="password" id="password"/></li>
                <li>
                    <a id="confirmLoginBtn" class="loginBtn" href="javascript:" onclick="cofirmLogin()">登录</a>
                    <a id="loginDialogCloseBtn" class="loginBtn" href="javascript:"
                       onclick="closeLoginDialog()">取消登录</a>
                </li>
            </ul>

        </div>
    </dialog>

    <div class="header-box">
        <div class="logo">
            <a href="/index"></a>
        </div>
        <div class="search-box">
            <input type="text" name="" id="" class="search" placeholder="请输入要查找的内容" autocomplete="off">
            <a href="javascript:;" class="search-btn">
            </a>
        </div>
        <div class="my-book">
            <a href="javascript:;" class="bookshelf">我的书架</a>
        </div>
    </div>

    <div class="main-nav-menu">
        <ul>
            <li class="nav-kind">
                <em>
                    <i></i>
                    <i></i>
                    <i></i>
                </em> 作品分类 <i class="arrow-img"></i>

            </li>
            <div class="center-left">
                <ul>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe642</em>
                        玄幻
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe62f</em>
                        奇幻
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe60f</em>
                        武侠
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe610</em>
                        仙侠
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe62c</em>
                        都市
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe602</em>
                        军事
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe616</em>
                        历史
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe612</em>
                        游戏
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe631</em>
                        体育
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe603</em>
                        科幻
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe641</em>
                        灵异
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe607</em>
                        言情
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe614</em>
                        耽美
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe617</em>
                        二次元
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&nbsp;</em>
                    </li>
                </ul>
            </div>
            <li class="nav-li" onclick="location.href='/allWorks'">全部作品</li>
            <li class="nav-li" onclick="location.href='/rankPage'">排行</li>
        </ul>
    </div>

    <div class="main-content-box">
        <div class="box-left">
            <div class="top-kind">
                <a href="/rankPage">人气榜单</a>
            </div>
            <ul class="o-kind">
                <li class="o-kind-t">热门作品排行</li>
                <li><a href="\monthTicketRank">月票榜</a></li>
                <li><a href="\recTicketRank">推荐票榜</a></li>
                <li><a href="javascript:void(0);">收藏榜</a></li>
                <li><a href="javascript:void(0);">更新榜</a></li>
                <li><a href="javascript:void(0);">打赏榜</a></li>
                <li><a href="javascript:void(0);">昨日热销榜</a></li>
            </ul>
        </div>
        <div class="box-right">
            <div class="r-title">
                <h2>人气榜单 <span id="update_time">2020-4-12 00:00&nbsp;更新</span> <span class="top-rule">榜单规则</span></h2>
            </div>
            <ul class="kind-menu">
                <li class="all-kinds">全部分类</li>
            </ul>
            <div class="top-list-det">
                <div class="hot-list-item-3 top-hot">
                    <div class="list-item-header">
                        月票榜
                    </div>
                    <ul id="month_ticket_rank">
                    </ul>
                </div>
                <div class="hot-list-item-3 top-hot clear">
                    <div class="list-item-header">
                        推荐票榜
                    </div>
                    <ul id="recom_ticket_list">
                    </ul>
                </div>
                <div class="hot-list-item-3 top-hot ">
                    <div class="list-item-header">
                        收藏榜
                    </div>
                    <ul id="collection_list">
                    </ul>
                </div>
                <div class="hot-list-item-3 top-hot">
                    <div class="list-item-header">
                        更新榜
                    </div>
                    <ul id="update_rankTop10_list">
                    </ul>
                </div>
                <div class="hot-list-item-3 top-hot">
                    <div class="list-item-header">
                        打赏榜
                    </div>
                    <ul id="award_rankTop10_list">
                    </ul>
                </div>
                <div class="hot-list-item-3 top-hot clear">
                    <div class="list-item-header">
                        昨日热销榜
                    </div>
                    <ul id="yesterday_sell_rankTop10_list">
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/static/js/rank.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/login.js"></script>
</html>