$.fn.extend({
	// 表单转成对象
	getJSONObjectFromForm : function() {
		var jsonObj = {};
		var params = decodeURIComponent(this.serialize(), true).split("&");
		$.each(params, function() {
			var param = this.split("=");
			var key = param[0].substring(param[0].lastIndexOf(".") + 1)
			jsonObj[key] = param[1].replaceText();
		})
		return jsonObj;
	},
	// 获取全部数据
	getGridData : function() {
		var data = [], _self = this;
		$.each(_self.jqGrid("getDataIDs"), function() {
			_self.jqGrid("saveRow", this);
			var obj = _self.jqGrid("getRowData", this);
			$.each(obj, function(k, v) {
				obj[k] = $.trim(v);
			})
			data.push(obj);
		});
		return data;
	},
	// 添加行，并处于编辑状态
	addGridRow : function() {
		var _self = this;
		var id = this.attr('id');
		$.each(_self.jqGrid("getDataIDs"), function() {
			_self.jqGrid("saveRow", this);
		});
		var fn = id.substring(0, id.length - 4) + 'EditRow("' + rowId + '")';
		var rowId = $.UUID();
		_self.jqGrid("addRowData", rowId, JSON.stringify(_self.jqGrid()
				.getGridParam("colModel")), "last");
		eval('(' + fn + ')');
		_self.jqGrid("setSelection", rowId);
		return rowId;
	},
	// 获取选中数据，可多选
	getSelectedData : function() {
		var data = [], _self = this;
		var ids = _self.jqGrid('getGridParam', 'selarrrow');
		var multi = _self.jqGrid('getGridParam', 'multiselect');
		var id = _self.jqGrid('getGridParam', 'selrow');
		if (!multi && id)
			ids[0] = id;
		$.each(ids, function() {
			data.push(_self.jqGrid('getRowData', this));
		})
		return data;
	},
	// 删除选中数据
	deleteGridRow : function() {
		var _self = this;
		var ids = _self.jqGrid('getGridParam', 'selarrrow');
		var multi = _self.jqGrid('getGridParam', 'multiselect');
		var id = _self.jqGrid('getGridParam', 'selrow');
		if (!multi && id)
			ids[0] = id;
		if (ids.length == 0)
			return layer.alert("至少选择一条数据", {
				icon : 0,
				title : '警告'
			});
		$.each(ids, function() {
			_self.jqGrid('delRowData', this);
		})
	},
	// 悬浮特效
	hoverSpecialEffects : function(url, colIndex, fn, title, width, height) {
		colIndex = colIndex || 0, title = title || '选择窗', width = width || '80%',
				height = height || '90%', fn = fn || callback;
		var tempObj, tdObj, button = `<button class="btn btn-success btn-sm" 
				style="margin-left: 4px;" onclick="$.layerWindow('${url }', ${fn },
				'${title }', '${width }', '${height }');">选择</button>`;
		this.on({
			mouseenter : function() {
				tdObj = $(this).find('td').eq(colIndex);
				tempObj = tdObj.html();
				tdObj.html(tempObj + button);
			},
			mouseleave : function() {
				tdObj.html(tempObj);
				tdObj = tempObj = undefined;
			}
		}, 'tr')
	},
});

$.extend({
	UUID : function() {
		function S4() {
			return (((1 + Math.random()) * 0x10000) | 0).toString(16)
					.substring(1);
		}
		return (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4()
				+ "-" + S4() + S4() + S4());
	},
	layerWindow : function(url, fn, title, width, height) {
		fn = fn || callback, title = title || '选择窗',
				width = width || '80%', height = height || '90%';
		top.layer.open({
			type : 2,
			title : title,
			area : [ width, height ],
			shadeClose : false,
			content : url,
			btn : [ '确认', '取消' ],
			yes : function(index, layero) {
				var objectList = $(layero).find('iframe')[0].contentWindow.objectList;
				fn(objectList);
				top.layer.close(index);
			}
		});
	},
	layerWindow2 : function(url, fn, gridId, title, width, height) {
		fn = fn || callback, title = title || '选择窗', gridId = gridId || 'jqGrid',
				width = width || '80%', height = height || '90%';
		top.layer.open({
			type : 2,
			title : title,
			area : [ width, height ],
			shadeClose : false,
			content : url,
			btn : [ '确认', '取消' ],
			yes : function(index, layero) {
				var grid = top.layer.getChildFrame('#' + gridId, index);
				//var objectList = $(layero).find('iframe')[0].contentWindow.objectList;
				var datas = $(grid).getSelectedData();
				if(datas.length > 1)
					return top.layer.alert('只能选择一条记录');
				fn(datas[0]);
				top.layer.close(index);
			}
		});
	}
})

/**
 * f1：数值1
 * f2：数值2
 * digit：扩大位数
 * precision：保留位数
 */
var floatOperation = {
	add : function(f1, f2, digit, precision) {
		precision = precision || 2, digit = digit || 2;
		var baseNum = Math.pow(10, digit);
		return ((f1 * baseNum + f2 * baseNum) / baseNum).toFixed(precision);
	},
	minus: function(f1, f2, digit, precision) {
		precision = precision || 2, digit = digit || 2;
		var baseNum = Math.pow(10, digit);
		return ((f1 * baseNum - f2 * baseNum) / baseNum).toFixed(precision);
	},
	mulitply : function(f1, f2, digit, precision) {
		precision = precision || 2, digit = digit || 2;
		var baseNum = Math.pow(10, digit);
		return (f1 * baseNum * (f2 * baseNum) / Math.pow(10, digit * 2)).toFixed(precision);
	},
	divide: function(f1, f2, digit, precision) {
		precision = precision || 2, digit = digit || 2;
		var baseNum = Math.pow(10, digit);
		return (f1 * baseNum / (f2 * baseNum)).toFixed(precision);
	}
}

String.prototype.replaceText = function () { return this.replace(/\+/g, ' ') };
