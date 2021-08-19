<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Register</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form action="/board/modify" method="post">
					<input type="hidden" name="type" value="<c:out value='${cri.type}'/>" >
					<input type="hidden" name="keyword" value="<c:out value='${cri.keyword}'/>" >
					<input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum}'/>">
					<input type="hidden" name="amount" value="<c:out value='${cri.amount}'/>">
					<div class="form-group">
						<label>Bno</label> <input class="form-control" name="bno"
							readonly="readonly" value="<c:out value='${board.bno}'/>">
					</div>
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title"
							value="<c:out value='${board.title}'/>">
					</div>
					<div class="form-group">
						<label>Content</label>
						<textarea class="form-control" rows="5" name="content"> <c:out
								value='${board.content}' /></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer"
							value="<c:out value='${board.writer}'/>">
					</div>
					<button type="submit" data-oper="modify" class="btn btn-default">수정</button>
					<button type="submit" data-oper="remove" class="btn btn-default">삭제</button>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form");
		$('button').on("click", function(e) { 		//모든 button태그에 대한 클릭 이벤트 처리
			e.preventDefault(); 					//버튼의 기본 submit() 동작 막기
			var operation = $(this).data("oper");	//data-oper 값 읽어오기
			console.log(operation);

			if (operation === 'remove') {
				if (confirm("게시글을 삭제하시겠습니까?") == true) {
					alert("게시글이 삭제되었습니다.");
					formObj.attr("action", "/board/remove");
				} else {
					return false;
				}
			} /*else if (operation === 'list') {
				//move to list
				formObj.attr("action", "/board/list").attr("method", "get");
				formObj.empty(); //list페이지로 이동시에는 form 데이터가 필요없으므로 내용을 비움
			*/else {
				alert("게시글이 수정되었습니다.");
			}
			formObj.submit();
		})
	})
</script>
<%@include file="../includes/footer.jsp"%>