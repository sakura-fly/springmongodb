jQuery.extend({
arp : function(o){
	$.ajax( {  type : 'post', cache:false  , sync : false , dataType : 'json', url : o.url ,  data : o.data , success : function( en ) {	  o.fn && o.fn(en)  }, error : function(data) {  	 alert("\u5bf9\u4e0d\u8d77\uff0c\u670d\u52a1\u5668\u6b63\u5fd9\u0021");  }});
},arpa : function(o){	$.ajax( {  type : 'post', cache:false  , async : true , timeout: 7000 , dataType : 'json', url : o.url ,  data : o.data , success : function( en ) {	  o.fn && o.fn(en)  }, error : function(data) {  	 o.fnc && o.fnc(data)   }});
}
});
 jQuery.prototype.so=function(){  
    var obj=new Object();  
    $.each(this.serializeArray(),function(index,param){  
       if(!(param.name in obj)){  
            obj[param.name]=param.value;  
        }  
    });  
    return obj;  
};


jQuery.fn.pagination = function(opts){var maxentries =0,opts = jQuery.extend({
		colspan : 4,
		pager_rowcontainer : null,
		items_per_page:50,
		num_display_entries:10,
		current_page:0,
		num_edge_entries:2,
		link_to:"javascript:void(0);",
		prev_text:"\u003c\u4e0a\u4e00\u9875",
		next_text:"\u4e0b\u4e00\u9875\u003e",
		ellipse_text:"\u002e\u002e\u002e",
		prev_show_always:true,
		next_show_always:true,
		url:"",query:{},
		callback:function(){return false;}
	},opts||{});return this.each(function() {
		function numPages() {
			var tmp = Math.ceil(maxentries/opts.items_per_page);
			if(tmp == 0) return 1;
			return Math.ceil(maxentries/opts.items_per_page);
		};
		function getData() {
			var q = current_page  + 1 , rs={};
			jQuery.extend(opts.query, {page: q});
			opts.pager_rowcontainer.html("<tr><td colspan=" + (opts.colspan) +" style='text-align:center;'>\u6b63\u5728\u52a0\u8f7d\u4fe1\u606f\uff0c\u8bf7\u7a0d\u540e\uff01</td></tr>");
			return $.ajax({type: "post",url: opts.url , cache:false,  data : opts.query  , async: false,dataType:"json", 
					success: function(res){
						if(res.hasOwnProperty('timeout')){
						     return top.location.href= QHDomain.cdn + '/SysUser/login' , true;
						}else{
							maxentries = res.recordTotal;
							rs =  res.data;
						}
					}
			}),rs;
		};
		function getInterval()  {
			var ne_half = Math.ceil(opts.num_display_entries/2);
			var np = numPages();
			var upper_limit = np-opts.num_display_entries;
			var start = current_page>ne_half?Math.max(Math.min(current_page-ne_half, upper_limit), 0):0;
			var end = current_page>ne_half?Math.min(current_page+ne_half, np):Math.min(opts.num_display_entries, np);
			return [start,end];
		};
		function pageSelected(page_id, evt){
			current_page = page_id;
			var dq = drawLinks();
			var continuePropagation = opts.callback(page_id, panel , dq);
			if (!continuePropagation) {
				if (evt.stopPropagation) {
					evt.stopPropagation();
				}
				else {
					evt.cancelBubble = true;
				}
			};
			return continuePropagation;
		};
		function drawLinks() {
			panel.empty();
			var data = getData();
			var interval = getInterval();
			var np = numPages();
			var getClickHandler = function(page_id) {
				return function(evt){ return pageSelected(page_id,evt); }
			};
			var appendItem = function(page_id, appendopts){
				page_id = page_id<0?0:(page_id<np?page_id:np-1); 
				appendopts = jQuery.extend({text:page_id+1, classes:""}, appendopts||{});
				if(page_id == current_page){
					var lnk = jQuery("<span class='current'>"+(appendopts.text)+"</span>");
				}
				else
				{
					var lnk = jQuery("<a>"+(appendopts.text)+"</a>")
						.bind("click", getClickHandler(page_id))
						.attr('href', opts.link_to.replace(/__id__/,page_id));
				};
				if(appendopts.classes){lnk.addClass(appendopts.classes);}
				panel.append(lnk);
			};
			if(opts.prev_text && (current_page > 0 || opts.prev_show_always)){
				appendItem(current_page-1,{text:opts.prev_text, classes:"prev"});
			};
			if (interval[0] > 0 && opts.num_edge_entries > 0)
			{
				var end = Math.min(opts.num_edge_entries, interval[0]);
				for(var i=0; i<end; i++) {
					appendItem(i);
				};
				if(opts.num_edge_entries < interval[0] && opts.ellipse_text)
				{
					jQuery("<span>"+opts.ellipse_text+"</span>").appendTo(panel);
				};
			};
			for(var i=interval[0]; i<interval[1]; i++) {
				appendItem(i);
			};
			if (interval[1] < np && opts.num_edge_entries > 0)
			{
				if(np-opts.num_edge_entries > interval[1]&& opts.ellipse_text)
				{
					jQuery("<span>"+opts.ellipse_text+"</span>").appendTo(panel);
				};
				var begin = Math.max(np-opts.num_edge_entries, interval[1]);
				for(var i=begin; i<np; i++) {
					appendItem(i);
				};
				
			};
			if(opts.next_text && (current_page < np-1 || opts.next_show_always)){
				appendItem(current_page+1,{text:opts.next_text, classes:"next"});
			};
			return data;
		};
		var current_page = opts.current_page;
		maxentries = (!maxentries || maxentries < 0)?1:maxentries;
		opts.items_per_page = (!opts.items_per_page || opts.items_per_page < 0)?1:opts.items_per_page;
		var panel = jQuery(this);
		this.selectPage = function(page_id){ pageSelected(page_id);};
		this.prevPage = function(){ 
			if (current_page > 0) {
				pageSelected(current_page - 1);
				return true;
			}
			else {
				return false;
			}
		};
		this.nextPage = function(){ 
			if(current_page < numPages()-1) {
				pageSelected(current_page+1);
				return true;
			}
			else {
				return false;
			}
		};
		var d = drawLinks();
        opts.callback(current_page, this, d );
	});
};



(function($, window, document, undefined) {
	function Paging(element, options) {
		this.element = element;
		this.options = {
			pageNo: 1,
			totalPage: options.totalPage,
			totalSize:options.totalSize,
			callback:options.callback
		};
		this.init();
	}
	Paging.prototype = {
		constructor: Paging,
		init: function() {
			this.creatHtml();
			this.bindEvent();
		},
		creatHtml: function() {
			var me = this;
			var content = "";
			var current = me.options.pageNo;
			var total = me.options.totalPage;
			var totalNum = me.options.totalSize;
			content += "<a id=\"firstPage\">首页</a><a id='prePage'>上一页</a>";
			if(total > 6) {
				if(current < 5) {
					for(var i = 1; i < 6; i++) {
						if(current == i) {
							content += "<a class='current'>" + i + "</a>";
						} else {
							content += "<a>" + i + "</a>";
						}
					}
					content += ". . .";
					content += "<a>"+total+"</a>";
				} else {
					if(current < total - 3) {
						for(var i = current - 2; i < current + 3; i++) {
							if(current == i) {
								content += "<a class='current'>" + i + "</a>";
							} else {
								content += "<a>" + i + "</a>";
							}
						}
						content += ". . .";
						content += "<a>"+total+"</a>";
					} else {
						content += "<a>1</a>";
						content += ". . .";
						for(var i = total - 4; i < total + 1; i++) {
							if(current == i) {
								content += "<a class='current'>" + i + "</a>";
							} else {
								content += "<a>" + i + "</a>";
							}
						}
					}
				}
			} else {
				for(var i = 1; i < total + 1; i++) {
					if(current == i) {
						content += "<a class='current'>" + i + "</a>";
					} else {
						content += "<a>" + i + "</a>";
					}
				}
			}
			content += "<a id='nextPage'>下一页</a>";
			content += "<a id=\"lastPage\">尾页</a>";
			content += "<span class='totalPages'> 共<span>"+total+"</span>页 </span>";
			content += "<span class='totalSize'> 共<span>"+totalNum+"</span>条记录 </span>";
			me.element.html(content);
		},
		bindEvent: function() {
			var me = this;
			me.element.on('click', 'a', function() {
				var num = $(this).html();
				var id=$(this).attr("id");
				if(id == "prePage") {
					if(me.options.pageNo == 1) {
						me.options.pageNo = 1;
					} else {
						me.options.pageNo = +me.options.pageNo - 1;
					}
				} else if(id == "nextPage") {
					if(me.options.pageNo == me.options.totalPage) {
						me.options.pageNo = me.options.totalPage
					} else {
						me.options.pageNo = +me.options.pageNo + 1;
					}

				} else if(num == "Go") {
					var ipt = +me.element.find('input').val();
					if(ipt && ipt <= me.options.totalPage && ipt != me.options.pageNo) {
						me.options.pageNo = ipt;
					}
				}else if(id =="firstPage") {
					me.options.pageNo = 1;
				} else if(id =="lastPage") {
					me.options.pageNo = me.options.totalPage;
				}else{
					me.options.pageNo = +num;
				}
				me.creatHtml();
				if(me.options.callback) {
					me.options.callback(me.options.pageNo);
				}
			});
		}
	};
	$.fn.paging = function(options) {
		return new Paging($(this), options);
	}
})(jQuery, window, document);