(function(jQuery) {
	$.fn.reminds = function(settings) {
		var defaults = {
			background : '#FFF',
			title : 'NEWS',
			titlecolor : '#FFF',
			titlebgcolor : '#5aa628',
			linkcolor : '#333',
			linkhovercolor : '#5aa628',
			fonttextsize : 16,
			isbold : false,
			border : 'none',
			width : '100%',
			autoplay : true,
			timer : 3000,
			modulid : 'brekingnews',
			effect : 'fade' //or slide	
		};
		var settings = $.extend(defaults, settings);

		return this.each(function() {
			settings.modulid = "#" + $(this).attr("id");
			var timername = settings.modulid;
			var activenewsid = 1;

			if (settings.isbold == true)
				fontw = 'bold';
			else
				fontw = 'normal';

			if (settings.effect == 'slide')
				$(settings.modulid + ' ul li').css({
					'display' : 'block'
				});
			else
				$(settings.modulid + ' ul li').css({
					'display' : 'none'
				});

			$(settings.modulid + ' .bn-title').html(settings.title);
			$(settings.modulid).css({
				'width' : settings.width,
				'background' : settings.background,
				'border' : settings.border,
				'font-size' : settings.fonttextsize
			});
			$(settings.modulid + ' ul').css({
				'left' : $(settings.modulid + ' .bn-title').width() + 40
			});
			$(settings.modulid + ' .bn-title').css({
				'background' : settings.titlebgcolor,
				'color' : settings.titlecolor,
				'font-weight' : fontw
			});
			$(settings.modulid + ' ul li a').css({
				'color' : settings.linkcolor,
				'font-weight' : fontw,
				'height' : parseInt(settings.fonttextsize) + 6
			});
			$(settings.modulid + ' ul li').eq(parseInt(activenewsid - 1)).css({
				'display' : 'block'
			});

			$(settings.modulid + ' ul li a').hover(function() {
				$(this).css({
					'color' : settings.linkhovercolor
				});
			},
				function() {
					$(this).css({
						'color' : settings.linkcolor
					});
				}
			);


			$(settings.modulid + ' .bn-arrows span').click(function(e) {
				if ($(this).attr('class') == "bn-arrows-left")
					BnAutoPlay('prev');
				else
					BnAutoPlay('next');
			});

			if (settings.autoplay == true) {
				timername = setInterval(function() {
					BnAutoPlay('next')
				}, settings.timer);
				$(settings.modulid).hover(function() {
					clearInterval(timername);
				},
					function() {
						timername = setInterval(function() {
							BnAutoPlay('next')
						}, settings.timer);
					}
				);
			} else {
				clearInterval(timername);
			}

			function BnAutoPlay(pos) {
				if (pos == "next") {
					if ($(settings.modulid + ' ul li').length > activenewsid)
						activenewsid++;
					else
						activenewsid = 1;
				} else {
					if (activenewsid - 2 == -1)
						activenewsid = $(settings.modulid + ' ul li').length;
					else
						activenewsid = activenewsid - 1;
				}

				if (settings.effect == 'fade') {
					$(settings.modulid + ' ul li').css({
						'display' : 'none'
					});
					$(settings.modulid + ' ul li').eq(parseInt(activenewsid - 1)).fadeIn();
				} else {
					$(settings.modulid + ' ul').animate({
						'marginTop' : -($(settings.modulid + ' ul li').height() + 20) * (activenewsid - 1)
					});
				}
			}

			$(window).resize(function(e) {
				if ($(settings.modulid).width() < 360) {
					$(settings.modulid + ' .bn-title').html('&nbsp;');
					$(settings.modulid + ' .bn-title').css({
						'width' : '2rem',
						'padding' : '10px 0px'
					});
					$(settings.modulid + ' ul').css({
						'left' : '2rem'
					});
				} else {
					$(settings.modulid + ' .bn-title').html(settings.title);
					$(settings.modulid + ' .bn-title').css({
						'width' : 'auto',
						'padding' : '10px 20px'
					});
					$(settings.modulid + ' ul').css({
						'left' : '2rem'
					});
				}
			});
		});
	};
})(jQuery);
$('#reminds').reminds({
	title : '滚动新闻',
	titlebgcolor : '#099',
	linkhovercolor : '#099',
	/*border: '1px solid #099',*/
	timer : 3000,
	effect : 'slide'
});
function stop() {
	return false;
}
document.oncontextmenu = stop;

/*--------- 无限加载 -----------*/
//加载flag
var loading = false;
// 最多可加载的条目
var hmaxItems = 100;
var fmaxItems = 100;
// 每次加载添加多少条目
var itemsPerLoad = 6;
var pageNum = 1 ;
var reqDataf={};
function addItems(ftype,reqData) {
	reqData["ftype"]=ftype;
	// 生成新条目的HTML
	var html = '';
	if (ftype==0) {
		pageNum = $("#hnextPage").text() ==''?1:$("#hnextPage").text();
	} else if (ftype==1) {
		reqData["sort"] = 1;
		pageNum = $("#fnextPage").text() ==''?1:$("#fnextPage").text();
	}
	$.ajax({
		type : "GET",
		url : "../shop/getSyList",
		data : {
			pageNum : pageNum,
			pageSize : itemsPerLoad,
			reqData : JSON.stringify(reqData)
		},
		dataType : "html",
		contentType : "application/json", 
		async:false,
		success : function(data) {
			if (ftype==0) {
				$('#htotal').remove();
				$('#hnextPage').remove();
				$('.home').append(data);
				hmaxItems = $("#htotal").text();
			} else if (ftype==1) {
				$('#ftotal').remove();
				$('#fnextPage').remove();
				$('.find').append(data);
				fmaxItems = $("#ftotal").text();
			}
		},
		error : function(data) {
			$.toast("老哥，不要慌，请刷新页面后重试。。。。。。");
		}
	});
	lazy();
}
//预先加载20条
addItems(0,{});
addItems(1,reqDataf);

// 上次加载的序号

var lastIndex = 6;

// 注册'infinite'事件处理函数
$(document).on('infinite', '.infinite-scroll-bottom', function() {
	if ($("#home").hasClass("active")) {
		// 更新最后加载的序号
		lastIndex = $('.home li').length;
		// 如果正在加载，则退出
		if (loading) return;
		// 设置flag
		loading = true;

		// 模拟1s的加载过程
		setTimeout(function() {
			if (lastIndex >= hmaxItems) {
				// 加载完毕，则注销无限加载事件，以防不必要的加载
				$.detachInfiniteScroll($('#homeScroll'));
				// 删除加载提示符
				$('#homePreloader').remove();
				$.toast("老哥,没有更多了");
				loading = false;
				return;
			}
			// 添加新条目
			addItems(0,{});
			// 重置加载flag
			loading = false;
		}, 200);
	} else if ($("#find").hasClass("active")) {
		// 更新最后加载的序号
		lastIndex = $('.find li').length;
		// 如果正在加载，则退出
		if (loading) return;
		// 设置flag
		loading = true;

		// 模拟1s的加载过程
		setTimeout(function() {
			if (lastIndex >= fmaxItems) {
				// 加载完毕，则注销无限加载事件，以防不必要的加载
				$.detachInfiniteScroll($('#findScrell'));
				// 删除加载提示符
				$('#findPreloader').remove();
				$.toast("老哥,没有更多了");
				loading = false;
				return;
			}
			// 添加新条目
			addItems(1,reqDataf);
			// 重置加载flag
			loading = false;
		}, 200);
	}
});

$(document).on('click', '.tka', function() {
	$(".popup").load("../shop/getProductInfo", {
		id : $(this).attr("id")
	}, function(response, statusTxt, xhr) {
		if (statusTxt == "success") {
//			alert(response);
		}else if (statusTxt == "error") {
			$.toast("老哥，不要慌，请刷新页面后重试。。。。。。");
		}
	})
	$.popup('.popup-services');
});

function reqShop(pid,url) {
	$.ajax({
		type : "GET",
		url : "../shop/reqShop",
		data : {
			pid : pid,
		},
		dataType : "json",
		async:true,
		success : function(data) {
			var data = eval(data );
			if (data.state != 0) {
				$.toast("老哥，不要慌，请刷新页面后重试。。。");
			} else {
				window.location.href=url;
				/*window.location.replace(url);*/
			}
		},
		error : function(data) {
			$.toast("老哥，不要慌，请刷新页面后重试。。。");
		}
	})
}

function lazy() {
	$("img").lazyload({
		placeholder : "../shopMain/images/loading.gif", //用图片提前占位
		// placeholder,值为某一图片路径.此图片用来占据将要加载的图片的位置,待图片加载时,占位图则会隐藏
		effect : "show", // 载入使用何种效果
		// effect(特效),值有show(直接显示),fadeIn(淡入),slideDown(下拉)等,常用fadeIn
		threshold : 200, // 提前开始加载
		// threshold,值为数字,代表页面高度.如设置为200,表示滚动条在离目标位置还有200的高度时就开始加载图片,可以做到不让用户察觉
		event : 'scroll', // 事件触发时才加载
		// event,值有click(点击),mouseover(鼠标划过),sporty(运动的),foobar(…).可以实现鼠标莫过或点击图片才开始加载,后两个值未测试…
		container : $(".page"), // 对某容器中的图片实现效果
		// container,值为某容器.lazyload默认在拉动浏览器滚动条时生效,这个参数可以让你在拉动某DIV的滚动条时依次加载其中的图片
		failurelimit : 10 // 图片排序混乱时
	// failurelimit,值为数字.lazyload默认在找到第一张不在可见区域里的图片时则不再继续加载,但当HTML容器混乱的时候可能出现可见区域内图片并没加载出来的情况,failurelimit意在加载N张可见区域外的图片,以避免出现这个问题.
	});
};
function reload(){
	$(".popup").load("../shop/getProductInfo", {
		id : $("#pid").text()
	}, function(response, statusTxt, xhr) {
		if (statusTxt == "success") {
//			alert(response);
		}else if (statusTxt == "error") {
			$.toast("老哥，不要慌，请刷新页面后重试。。。。。。");
		}
	})
}
$(".kzzt").click(function(e) {
	if ($(e.target).attr("id") == "dark-switch") {
		if ($("body").hasClass('theme-dark')) {
			$("body").removeClass("theme-dark");
			$(".pTypes").removeClass("darkY");
			$(".easing").removeClass("darkY");
			$(".tc1").removeClass("darkY");
			$(".tc2").removeClass("darkY");
			$(".tc2 li").removeClass("darkY");
		} else {
			$("body").addClass("theme-dark");
			$(".pTypes").addClass("darkY");
			$(".easing").addClass("darkY");
			$(".tc1").addClass("darkY");
			$(".tc2").addClass("darkY");
			$(".tc2 li").addClass("darkY");
		}
	} else if ($(e.target).attr("id") == "theme-pink") {
		if ($("body").hasClass('theme-pink')) {
			$("body").removeClass("theme-pink");
		} else {
			$("body").addClass("theme-pink");
		}
	} else if ($(e.target).attr("id") == "theme-green") {
		if ($("body").hasClass('theme-green')) {
			$("body").removeClass("theme-green");
		} else {
			$("body").addClass("theme-green");
		}
	} else if ($(e.target).attr("id") == "theme-yellow") {
		if ($("body").hasClass('theme-yellow')) {
			$("body").removeClass("theme-yellow");
		} else {
			$("body").addClass("theme-yellow");
		}
	}
});
/**
 * 禁用滚动条
 */
function unScroll() {
	var top = $(document).scrollTop();
	$(document).on('scroll.unable', function(e) {
		$(document).scrollTop(top);
	})
}
/**
 * 解除禁用滚动条
 */
function removeUnScroll() {
	$(document).unbind("scroll.unable");
}
var $cov1Btn = $('.tc1>span')
, $cov2Btn = $('.tc2>ul>li')
, $topSpan = $('.pTypes>span');
/*------筛选弹窗------*/
pTypesClick();

function pTypesClick() {
	/*------顶部筛选弹窗------*/
	$topSpan.click(function() {
		var idx = $(this).index();
		if ($(this).hasClass('topClick')) {
			$(this).removeClass('topClick');
			$('.tcc').hide();
			removeUnScroll();
		} else {
			$(this).addClass('topClick').siblings('span').removeClass('topClick');
			$('.tcc').show();
			var coverH1 = $('.tc1').height(),
				coverH2 = $('.tc2').height()
			$('.tc1').css({
				"top" : -coverH1
			});
			$('.tc2').css({
				"top" : -coverH2
			});
			$('.tcc>div').eq(idx).animate({
				"top" : 0
			});
			unScroll();
		}
		$('.tcc').click(function() {
			$(this).hide();
			$topSpan.removeClass('topClick');
			removeUnScroll();
		})
	});
}
/*------弹窗内选项点击------*/
tcClick();

function tcClick() {
   $cov1Btn.click(function () {
       $(this).addClass('tc1Click').siblings('span').removeClass('tc1Click');
       $('.ptype>em').text($(this).text())
       reqDataf["type"] = $(this).attr("id");
       $("#fnextPage").text(1);
       $('.find').empty();
       addItems(1,reqDataf);
   });
   $cov2Btn.click(function () {
	   $(this).addClass('tc2Click').siblings('li').removeClass('tc2Click');
       $('.dked>em').text($(this).text().replace("万", "0000"));
       reqDataf["endQuota"] = $(this).text().replace("万", "0000").replace("元", "").replace("贷款额度", "");
       $("#fnextPage").text(1);
       $('.find').empty();
       addItems(1,reqDataf);
   });
}
$(function() {
	$.init();
});