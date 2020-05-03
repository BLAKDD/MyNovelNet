<%--
  Created by IntelliJ IDEA.
  User: BLAKD
  Date: 2020/4/18
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title id="title">Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Autocomplate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Dropdown.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/demo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/read.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/myCss.css">

    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/md5.js"></script>
</head>

<body>
<input type="hidden" id="chapterUuid" value="${chapterUuid}">
<input type="hidden" id="novelUuid" value="${novelUuid}">
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
    <div class="path">
        <a href="javascript:void(0);">首页</a>
        <em class="iconfont">&#xe621;</em>
        <a id="pCategory" href="javascript:void(0);">科幻</a>
        <em class="iconfont">&#xe621;</em>
        <a id="category" href="javascript:void(0);">时空穿梭</a>
        <em class="iconfont">&#xe621;</em>
        <a id="novelNameUp" href="javascript:void(0);">诸天单机大玩家</a>
    </div>
    <div class="read-body" id="readBody">
        <div class="body-left" id="bodyLeft">
            <a href="javascript:void(0);" class="book-mark"></a>
            <div class="chapter-title">
                <span id="chapterName">第二章&nbsp;世界任务开启！</span>
                <span class="com-tag" id="mark">2 <i class="title-mark" id="titleMark"></i></span>
            </div>
            <div class="book-info">
                <a href="javascript:void(0);">
                    <em class="iconfont">&#xe60c;</em>
                    <span id="novelNamedown">诸天单机大玩家</span>
                </a>
                <a href="javascript:void(0);">
                    <em class="iconfont">&#xe650;</em>
                    <span id="writerName">若清峰</span>
                </a>
                <span class="infoSpan">
                        <em class="iconfont">&#xe64f;</em>
                        <span id="wordCount">2000</span>
                        <i>字</i>
                    </span>
                <span class="infoSpan">
                        <em class="iconfont">&#xe653;</em>
                        <span id="updateTime">2020-4-18 00:00</span>
                    </span>
            </div>
            <div class="book-text" id="bookText">
            </div>
        </div>
        <div class="chap-com" id="comment">
            <span class="close" id="close"> </span>
            <div class="input-area" id="inputBox">
                    <textarea name="input" id="input" cols="30" rows="10" class="input"
                              placeholder="有什么想法快写下来吧"></textarea>
                <div class="release">
                    <span id="limit">0/150</span>
                    <a href="javascript:void(0);" id="release">发表</a>
                </div>
            </div>
            <div class="post">
                <div class="post-title">共1条帖子</div>
                <div class="post-item">
                    <div class="user-info">
                        <div class="img-container">
                            <img src="https://facepic.qidian.com/qd_face/349573/a400391497/0" alt="">
                        </div>
                        <div class="post-time">
                            <p class="user-name">胡为东</p>
                            <p class="time"><span>1楼·</span> 2020-4-17 00:00</p>
                        </div>
                    </div>
                    <p class="post-text">
                        WOW! You can really dance!
                    </p>
                    <div class="post-btn">
                            <span class="reply" id="reply">
                                <img src="https://imgservices-1252317822.image.myqcloud.com/image/20190622/077580802be5.png"
                                     alt="">
                                回复
                            </span>
                        <span>
                                <img src="https://imgservices-1252317822.image.myqcloud.com/image/20190622/70105696c5f0.png"
                                     alt="">
                                点赞
                            </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="read-fun" id="readFun">
        <a id="gotoLastChapter" href="javascript:void(0);">上一章</a>
        <span class="line"></span>
        <a href="/bookInfo?novelUuid=${novelUuid}">目录</a>
        <span class="line"></span>
        <a id="gotoNextChapter" href="javascript:void(0);">下一章</a>
    </div>
    <div class="left-nav public-nav" id="left">
        <ul id="leftBox">
            <li id="catalog">
                <a href="javascript:void(0);">
                    <em class="iconfont">&#xe619;</em>
                    目录
                </a>
            </li>
            <li id="set">
                <a href="javascript:void(0);">
                    <em class="iconfont">&#xe65b;</em>
                    设置
                </a>
            </li>
            <li>
                <a id="bookShelf" href="javascript:void(0);" disabled="true">
                    <em class="iconfont">&#xe654;</em>
                    <span id="bookShelfContent">书架</span>
                </a>
            </li>
            <li>
                <a href="/bookInfo?novelUuid=${novelUuid}">
                    <em class="iconfont">&#xe652;</em>
                    书页
                </a>
            </li>
        </ul>
        <div class="set" id="setPage">
            <span class="close" id="setclose"></span>
            <div class="set-title">设置</div>
            <div class="menu-wrap">
                <span class="menu-title">阅读主题</span>
                <span class="color-item" data-color="default">
                        <em class="iconfont">&#xe664;</em>
                    </span>
                <span class="color-item" data-color="0">
                        <em class="iconfont">&#xe664;</em>
                    </span>
                <span class="color-item" data-color="1">
                        <em class="iconfont">&#xe664;</em>
                    </span>
                <span class="color-item" data-color="2">
                        <em class="iconfont">&#xe664;</em>
                    </span>
                <span class="color-item" data-color="3">
                        <em class="iconfont">&#xe664;</em>
                    </span>
                <span class="color-item" data-color="4">
                        <em class="iconfont">&#xe664;</em>
                    </span>
                <span class="color-item" data-color="5">
                        <em class="iconfont">
                            &#xe664;
                        </em>
                    </span>
            </div>
            <div class="menu-wrap font">
                <span class="menu-title">正文字体</span>
                <span data-font="0" class="font-item font-selected">雅黑</span>
                <span data-font="1" class="font-item">宋体</span>
                <span data-font="2" class="font-item">楷书</span>
            </div>
            <div class="menu-wrap size">
                <span class="menu-title">正文字体</span>
                <div class="size-box">
                    <span class="size-menu" id="minus">A-</span>
                    <b></b>
                    <span class="size-menu" id="fontSize">18</span>
                    <b></b>
                    <span class="size-menu" id="plus">A+</span>
                </div>
            </div>
        </div>
        <div class="catalog" id="cataPage">
            <span class="close" id="cataClose"></span>
            <div class="set-title">目录</div>
            <div class="catalist-box">
                <ul class="catalog-list" id="catalogList">
                </ul>
            </div>

        </div>
    </div>
    <div class="right-nav public-nav" id="right">
        <ul id="rightBox">
            <li>
                <a href="jaascript:void(0);" onclick="openlbfPanel(3)">
                    <em class="iconfont">&#xe635;</em>
                    <span>打赏</span>
                </a>
            </li>
            <li>
                <a href="jaascript:void(0);" onclick="openlbfPanel(2)">
                    <em class="iconfont">&#xe65d;</em>
                    <span>投票</span>
                </a>
            </li>
            <li>
                <a href="jaascript:void(0);" id="menuMark">
                    <em class="iconfont">&#xe654;</em>
                    <span>章评</span>
                </a>
            </li>
            <li id="totop">
                <a href="jaascript:void(0);">
                    <em class="iconfont totop">&#xe651;</em>
                </a>
            </li>
        </ul>
    </div>
    <div class="reply-page" id="Rpage">
        <span class="close" id="Rclose"></span>
        <h3 class="reply-title">查看回复</h3>
        <div class="post-wrap">
            <div class="post-item">
                <div class="user-info">
                    <div class="img-container">
                        <img src="https://facepic.qidian.com/qd_face/349573/a400391497/0" alt="">
                    </div>
                    <div class="post-time">
                        <p class="user-name">胡为东</p>
                        <p class="post-text">
                            WOW! You can really dance!
                        </p>
                        <div class="post-btn">
                            <span class="time"> 2020-4-17 00:00</span>
                            <span class="reply" id="pageReply">
                                    <img src="https://imgservices-1252317822.image.myqcloud.com/image/20190622/077580802be5.png"
                                         alt="">
                                    回复
                                </span>
                            <span>
                                    <img src="https://imgservices-1252317822.image.myqcloud.com/image/20190622/70105696c5f0.png"
                                         alt="">
                                    点赞
                                </span>
                        </div>
                        <div class="release-input" id="relInput">
                            <textarea name="input" id="Rinput" cols="30" rows="10" class="input"></textarea>
                            <div class="release">
                                <span id="Rlimit">0/150</span>
                                <span class="cancel" id="cancel">取消</span>
                                <a href="javascript:void(0);" id="Rrelease">发表</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="reply-area">
        </div>
    </div>
    <div class="recharge-page" id="recharge">
        <span class="close" id="rechargeClose"></span>
        <h3 class="reply-title">充值页面</h3>
        <p>充书币：<input id="rechargeCoin" type="number"></p>
        <span class="rechargeBtn" id="rechargeBtn">充值</span>
    </div>
    <div class="recharge-page" id="subscribe">
        <span class="close" id="subscribeClose"></span>
        <h3 id="subscribeInfo" class="reply-title">是否订阅?</h3>
        <div style="text-align: center">
            <span class="rechargeBtn" id="subscribeBtn">订阅</span>
            <span class="rechargeBtn" id="autoSubscribeBtn">自动订阅</span>
        </div>
    </div>

    <div class="lbf-panel-body" id="lbfPanelBody">
        <span class="close" id="lbfPanelBodyClose"></span>
        <div class="vote-popup" id="votePopup" data-l1="15">
            <!-- start 弹窗切换tab-->
            <div class="popup-tab" id="popupTab">
                <a class="lang" href="javascript:" id="monthTab">投月票<em></em></a>
                <a class="lang" href="javascript:" id="recTab">投推荐票<em></em></a>
                <a class="lang act2" href="javascript:" id="rewardTab">打赏</a>
            </div>
            <!-- end 弹窗切换tab-->
            <!-- start 弹窗互动内容 -->
            <div class="vote-popup-wrap" id="voteWrap">
                <!-- start 投月票 -->
                <div class="popup-content month hidden" id="monthPopup" data-l2="1" style="display: none;">
                    <div class="no-limit-wrap">
                        <h3>剩余月票数<span id="monthTickBalance">1</span>张</h3>
                        <div class="vote-form-wrap">
                            <h4>投票数量</h4>
                            <p><input id="monthTicCount" type="number" max="3" min="1" value="1"
                                      onkeydown="return false;"></p>
                            <span class="rechargeBtn" id="voteMonthTicket">立即投票</span>
                        </div>
                    </div>
                </div>
                <!-- end 投月票 -->

                <!-- start 投推荐票 -->
                <div class="popup-content rec hidden" id="recPopup" data-l2="2" style="display: none;">
                    <!-- start 无限制可以投票 -->
                    <div class="no-limit-wrap">
                        <h3>剩余推荐票数<span id="recTickBalance">1</span>张</h3>
                        <div class="vote-form-wrap">
                            <h4>投票数量</h4>
                            <p><input id="recNum" type="number" max="3" min="1" value="1" onkeydown="return false;"></p>
                            <span class="rechargeBtn" id="voteRecTicket">立即投票</span>
                        </div>
                        <!-- end 无限制可以投票 -->
                    </div>
                </div>
                <!-- end 投推荐票 -->
                <!-- start 打赏 -->
                <div class="popup-content reward hidden" id="rewardPopup" style="display: block;">

                    <!-- start 无限制可以打赏 -->
                    <div class="no-limit-wrap">
                        <div class="vote-form-wrap">
                            <div class="reward-list cf" id="rewardList">
                                <ul>
                                </ul>
                            </div>
                        </div>
                        <div class="reward-tips">
                            <h4>账户余额<em id="balance">10000</em>起点币<i>·</i>本次打赏<em class="calcReward"
                                                                                  id="rewardCost">500</em>起点币</h4>
                        </div>

                        <div class="popup-btn">
                            <a class="red-btn" id="voteReward" href="javascript:">确认打赏</a>
                        </div>
                    </div>
                    <!-- end 无限制可以打赏 -->
                    <!-- end 打赏 -->
                </div>
                <!-- end 弹窗互动内容 -->
            </div>
        </div>
    </div>

</div>
</div>
<div class="shelter" id="shelter"></div>
<div class="shelter2" id="shelter2"></div>
<div class="shelter3" id="shelter3"></div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/login.js"></script>
<script src="${pageContext.request.contextPath}/static/js/read.js"></script>
</html>
