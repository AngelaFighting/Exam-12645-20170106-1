/**
 * 
 */
//加载语言列表
function loadLanguage(){
	var select=$("select[name='language.languageId']");
	$.ajax({
		type:"get",
		url:"language/list",
		async:false,
		dataType:"json",
   			success:function(data){
   				var len=data.length;
   				select.append("<option value='"+data[0].languageId
   						+"' selected='true'>"+data[0].name+"</option>");
   				for(var i=1;i<len;i++){
					select.append("<option value='"+data[i].languageId
					+"'>"+data[i].name+"</option>");
   				}
   			}
	});
}

/**
 * 查询film
 * @param param film_id
 */
function selectFilm(param){
	$.ajax({
		type:"get",
		url:"film/edit/"+param,
		async:false,
		dataType:"json",
		success:function(data){
			$("input[name='title']").val(data.title);
			$("select[name='language.languageId'] option:selected").attr("selected",false);
			$("select[name='language.languageId'] option[value='"+data.language.languageId+"']").attr("selected",true);
			$("textarea[name='description']").val(data.description);
		}
	});
}

/**
 * //设置分页的链接
 * @param {Object} index 页码
 * @param {Object} target 当前页码
 */
function setLink(index,target){
	var li="<li>";
	if(target==index){//当前页码
		li="<li class='active'>";
	}
	$(".pagination").append(li
		+"<a href='javascript:void(0);' "
		+"onclick='javascript:changeCurrentPageNum("
		+index+");return false;'>"
		+index+"</a></li>");
}

/**
 * 更新分页列表
 * @param {Object} param1 当前页码
 * @param {Object} param2 总页数
 */
function changePagination(param1,param2){
	$(".pagination").empty();//请客分类列表
	if(param2==1){//只有一页，则不显示分页列表
		$(".pagination").hide();
	}else{
		$(".pagination").show();//显示分页列表
		if(param2<=7){//总页数少于7
			for(var i=1;i<=param2;i++){
				setLink(i,param1);
			}							
		}else{//总页数大于7
			var first="<li><a href='javascript:void(0);' "
					+"onclick='javascript:changeCurrentPageNum(1);return false;'"
					+" title='第一页'>&lt;&lt;</a></li>";
			var last="<li><a href='javascript:void(0);' "
					+"onclick='javascript:changeCurrentPageNum("
					+param2+");return false;'"
					+" title='最后一页'>&gt;&gt;</a></li>";
			var pre="<li><a href='javascript:void(0);' "
					+"onclick='javascript:changeCurrentPageNum("
					+(param1-1)+");return false;'"
					+" title='上一页'>&lt;</a></li>";
			var next="<li><a href='javascript:void(0);' "
					+"onclick='javascript:changeCurrentPageNum("
					+(param1+1)+");return false;'"
					+" title=下一页'>&gt;</a></li>";
			if(param1<=3){//当前页码小于等于3
				for(var i=1;i<=5;i++){
					setLink(i,param1);
				}
				$(".pagination").append(next);
				$(".pagination").append(last);
			}
			else if(param2-param1<=3){//剩余页数不足3
				$(".pagination").append(first);
				$(".pagination").append(pre);
				for(var i=param2-4;i<=param2;i++){
					setLink(i,param1);
				}
			}else{
				$(".pagination").append(first);
				$(".pagination").append(pre);
				for(var i=param1-2;i<=param1+2;i++){
					setLink(i,param1);
				}
				$(".pagination").append(next);
				$(".pagination").append(last);
			}
		}
	}
}	

/**
 * 更新页数
 * @param {Object} param1 总页数
 * @param {Object} param2 当前页数
 */
function changePageList(param1,param2){
	$("#pageNum").empty();//清空页数列表
	for(var i=1;i<=param1;i++){
		if(i!=param2){
			$("#pageNum").append("<option value='"+i+"'>"+i+"</option>");
		}
		else{
			$("#pageNum").append("<option value='"+i+"' selected='true'>"+i+"</option>");
		}
	}			
}

/**
 * 分页查询
 * @param {Object} param1 偏移量offset
 * @param {Object} param2 记录数pageSize
 */
function queryFilm(param1,param2){
	$.ajax({		
		type:"get",
		url:"film/list?offset="+param1+"&pageSize="+param2,
		async:false,
		success:function(data){
			$("#film_table tbody").empty();//清空tbody
			/**？？？用普通的for循环除第一页可以在for循环中遍历data外，其余页面遍历不了**/
			$.each(data, function (n, value) {
				var i=param1+n;
				var film=value;
				$("#film_table tbody").append(
						"<tr><td class='btn_index'>"+(i+1)+"</td><td>"+film.title+"</td><td>"
						+film.language.name+"</td><td>"+film.description
						+"</td><td class='btn_td'><a href='film_form?id="+film.filmId
						+"'><button type='button' class='btn btn-primary'>"
						+"<span class='glyphicon glyphicon-pencil'></span>修改</button>"
						+"</a>&nbsp;&nbsp;&nbsp;&nbsp;<button "
						+"onclick='javascript:deleteFilm("+film.filmId
						+");return false;' type='button' class='btn btn-danger'>"
						+"<span class='glyphicon glyphicon-trash'></span>删除</button>"
						+"</td></tr>"
					);
			});
		}
	});
}
