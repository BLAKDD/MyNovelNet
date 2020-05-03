<%--
  Created by IntelliJ IDEA.
  User: BLAKD
  Date: 2020/3/27
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Autocomplate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Dropdown.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/demo.css">
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
                </em> 作品分类
            </li>
            <li class="nav-li" onclick="location.href='/allWorks'">全部作品</li>
            <li class="nav-li" onclick="location.href='/rankPage'">排行</li>
            <li id="writerPageId" class="nav-li hidden" onclick="location.href=''">作家专属</li>
        </ul>
    </div>

    <div class="main-center-box">
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
        <div class="center-right">
            <div class="roration-wrap">
                <div class="rotation-nav">
                    <a id="coverRecNovelName1" href="javascript:;" onclick="changeRotation(1)">test1</a>
                    <a id="coverRecNovelName2" href="javascript:;" onclick="changeRotation(2)">test2</a>
                    <a id="coverRecNovelName3" href="javascript:;" onclick="changeRotation(3)">test3</a>
                    <a id="coverRecNovelName4" href="javascript:;" onclick="changeRotation(4)">test4</a>
                    <a id="coverRecNovelName5" href="javascript:;" onclick="changeRotation(5)">test6</a>
                </div>
                <ul class="rotation" id="rotation">
                    <li><img id="coverRecimg1"
                             src=" https://img2.qidian.com/upload/gamesy/2020/03/09/20200309170924yrfkmcuqzd.jpg"
                             alt=""></li>
                    <li><img id="coverRecimg2"
                             src="  //bossaudioandcomic-1252317822.image.myqcloud.com/activity/document/6cfa16f5bcf3ea9f1c23608e67d4e76e.jpg"
                             alt=""></li>
                    <li><img id="coverRecimg3"
                             src=" https://img2.qidian.com/upload/gamesy/2020/03/09/20200309170924yrfkmcuqzd.jpg"
                             alt=""></li>
                    <li><img id="coverRecimg4"
                             src=" https://img2.qidian.com/upload/gamesy/2020/03/09/20200309170924yrfkmcuqzd.jpg"
                             alt=""></li>
                    <li><img id="coverRecimg5"
                             src=" https://img2.qidian.com/upload/gamesy/2020/03/09/20200309170924yrfkmcuqzd.jpg"
                             alt=""></li>
                </ul>
            </div>

        </div>
    </div>

    <div class="recommend-box">
        <div class="recommend-left">
            <div class="rec-title">本周强推</div>
            <ul class="rec-list" id="thisweekSR">
            </ul>
        </div>
        <div class="recommend-center">
            <div class="rec-title">编辑推荐</div>
            <div class="rec-detail">
                <div class="book-list">
                    <div class="arrow">
                        <em class="iconfont" onclick="changeBook('left')">&#xe628</em>
                    </div>
                    <ul class="book-img" id="book_box">
                        <li id="book_1" style="opacity: 0; transform: scale(0.4);"><img id="editor_rec_imgg1"
                                                                                        src="https://bookcover.yuewen.com/qdbimg/349573/1018180913/90"
                                                                                        alt="book_1">
                        </li>
                        <li id="book_2" style="transform: scale(0.6);"><img id="editor_rec_imgg2"
                                                                            src="https://bookcover.yuewen.com/qdbimg/349573/1015609210/90"
                                                                            alt="book_2">
                        </li>
                        <li id="book_3" style="transform: scale(0.8); z-index: 50;"><img id="editor_rec_imgg3"
                                                                                         src="https://bookcover.yuewen.com/qdbimg/349573/1017490344/90"
                                                                                         alt="book_3">
                        </li>
                        <li id="book_4" style="z-index: 100;"><img id="editor_rec_imgg4"
                                                                   src="https://bookcover.yuewen.com/qdbimg/349573/1019189022/90"
                                                                   alt="book_4">
                        </li>
                        <li id="book_5" style="transform: scale(0.8); z-index: 50;"><img id="editor_rec_imgg5"
                                                                                         src="https://bookcover.yuewen.com/qdbimg/349573/1016402042/90"
                                                                                         alt="book_5">
                        </li>
                        <li id="book_6" style="transform: scale(0.6); z-index: 1;"><img id="editor_rec_imgg6"
                                                                                        src="https://bookcover.yuewen.com/qdbimg/349573/1016311897/90"
                                                                                        alt="book_6">
                        </li>
                        <li id="book_7" style="opacity: 0;transform: scale(0.4)"><img id="editor_rec_imgg7"
                                                                                      src="https://bookcover.yuewen.com/qdbimg/349573/1018476807/90"
                                                                                      alt="book_7">
                        </li>
                    </ul>
                    <div class="arrow">
                        <em class="iconfont" onclick="changeBook('right')">&#xe621</em>
                    </div>
                </div>
                <div class="book-intro">
                    <div>
                        <h3 id="editorRecomTitle">title</h3>
                        <p id="editorRecomIntro">introduce 这是一段很长的介绍</p>
                    </div>
                    <a href="javascript:;" id="bookInfo" class="book-detail" target="_blank">书籍详情</a>
                </div>
            </div>
            <div class="rec-detail-list" id="editorRecomListUp">

            </div>
            <div class="rec-detail-list" id="editorRecomListDown" style="border-bottom: none;">
            </div>
        </div>
        <div class="recommend-right">
            <div class="rec-title">网文新风</div>
            <ul class="rec-list" id="thisweekSJ">
            </ul>
        </div>
    </div>

    <div class="hot-list-box">
        <div class="hot-list-item">
            <div class="list-item-header">
                月票榜
            </div>
            <ul id="month_ticket_rank">
            </ul>
        </div>
        <div class="hot-list-item">
            <div class="list-item-header">
                推荐票榜
            </div>
            <ul id="recom_ticket_list">
            </ul>
        </div>
        <div class="hot-list-item">
            <div class="list-item-header">
                收藏榜
            </div>
            <ul id="collection_list">
            </ul>
        </div>
        <div class="hot-list-item">
            <div class="list-item-header">
                更新榜
            </div>
            <ul id="update_rankTop10_list">
            </ul>
        </div>
        <div class="hot-list-item clear">
            <div class="list-item-header">
                打赏榜
            </div>
            <ul id="award_rankTop10_list">
            </ul>
        </div>
    </div>
    <div class="footer">
        <p>上海网警提示：网络刷单是违法 切莫轻信有返利，网上交友套路多 卖惨要钱需当心，电子红包莫轻点 个人信息勿填写，仿冒客服来行骗 官方核实最重要，招工诈骗有套路 预交费用需谨慎，低价充值莫轻信
            莫因游戏陷套路，连接WIFI要规范 确认安全再连接，抢购车票有章法 确认订单再付款，白条赊购慎使用 提升额度莫轻信，网购预付有风险 正规渠道很重要 如网民接到962110电话，请立即接听。</p>
        <div class="help">
            <a href="javascript:;">帮助中心</a>
            <a href="javascript:;">举报中心</a>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/login.js"></script>
<script src="${pageContext.request.contextPath}/static/js/index.js"></script>
</html>