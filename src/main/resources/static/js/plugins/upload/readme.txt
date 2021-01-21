引用文件：
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="jQuery.upload.mini.js"></script>
<link rel="stylesheet" href="upload.css">
	
调用代码：
<div class="upload" id="case" data-num="10" data-type="zip,pdf,doc,docx"></div>

<script type="text/javascript">
	$(function(){
		$("#case").upload(
			//该函数为点击放大镜的回调函数，如没有该函数，则不显示放大镜
			function(_this,data){
				console.log(data) 
			}
		);
	})
</script>
参数配置：
标签	默认值	说明
data-height	0	图片上传压缩最大高度，0则根据宽度等比例压缩
data-width	1920	图片上传压缩最大宽度，0则根据高度等比例压缩
data-type	png,jpg,jpeg,gif	允许上传文件的扩展名，多个扩展名用逗号分割，支持非图片格式的文件上传
data-file	file	上传提交服务器的表单名
data-name	uoload	最终表单提交图片路径的表单名
action	/upload.php	服务器接收上传文件的地址，服务器需返回{"code":1,"msg":"/upload/1.jpg"}的JSON字符串，code为上传状态，1为成功，0为失败，msg为成功的文件路径或失败原因提示！
data-num	10	最多可以上传多少个文件，如为1，上传插件为单个文件上传样式
data-size	20480	文件上传单个文件最大容量，图片不传不受该属性限制
data-value	null	已经上传成功的文件名，多个文件用英文逗号分割