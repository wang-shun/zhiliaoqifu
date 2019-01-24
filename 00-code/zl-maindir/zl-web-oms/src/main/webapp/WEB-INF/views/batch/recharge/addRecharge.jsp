<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/init.jsp"%>
    <%@ include file="/WEB-INF/views/common/head.jsp"%>
    <link rel="stylesheet" href="${ctx}/static/datetimepicker/css/bootstrap-datetimepicker.0.0.11.min.css" />
    <script src="${ctx}/static/datetimepicker/js/bootstrap-datetimepicker.0.0.11.min.js"></script>
    <script src="${ctx}/static/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="${ctx}/static/oms/js/batch/recharge/addRecharge.js"></script>
    <script src="${ctx}/static/jquery/jquery.form.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/navbar.jsp"%>
	<div id="contentwrapper">
	<div class="main_content">
		<nav>
			<div id="jCrumbs" class="breadCrumb module">
				<ul>
					<li><a href="#"><i class="icon-home"></i></a></li>
					<li>账户管理</li>
					<li><a href="${ctx }/batch/recharge/listRecharge.do">企业员工批量充值</a></li>
					<li>录入订单</li>
				</ul>
			</div>
		 </nav>
		<form id="pageMainForm" action="${ctx }/batch/recharge/intoAddRecharge.do" class="form-inline form_validation_tip" method="post">
			<input type="hidden" id="operStatus"  value="${operStatus }"/>
			<input type="hidden" id="accountType" name="accountType" value="${accountType.code }"/>
			<h3 class="heading">录入订单</h3>
			<div class="row-fluid" >
				<div class="span12">
	       			<div class="control-group formSep">
	 	   				<span class="add-on">订单名称：</span><input id="orderName" name="orderName" type="text" class="input-medium" value=""/>&nbsp;
	       	    		<span style="padding-left:  150px">
		       	    		<span class="add-on">企业名称：</span>
			            	<select name="companyId" id="companyId" class="input-medium" style="width: 180px">
								<option value="">--请选择--</option>
								<c:forEach var="c" items="${companyList}" varStatus="sta">
									<option value="${c.companyId}"   >${c.name}</option>
								</c:forEach>
			            	</select>
	       	    		</span>
	       	    		<span style="padding-left:  150px">
		      	    		<span class="add-on">充值账户：</span>
	       	    			<select name="billingType" id="billingType" class="input-medium" >
                               <c:forEach var="b" items="${billingTypeList}" varStatus="sta">
                                   <option value="${b.BId}">${b.BName}</option>
                               </c:forEach>
                             </select>
                     	</span>
	       	    		<%-- <span style="padding-left:  150px">
		      	    		<span class="add-on">账户类型：</span>
		                 	<select name="accountType" id="accountType" class="input-medium" style="width: 180px">
								<option value="">--请选择--</option>
								<c:forEach var="a" items="${accountTypeList}" varStatus="sta">
								    <option value="${a.code}"   >${a.value}</option>
								</c:forEach>
		                	</select>
	                	</span> --%>
	                  	<div class="pull-right">
	                  	<sec:authorize access="hasRole('ROLE_BATCH_RECHARGE_UPLOAD_FILE')">
		                                    <button class="btn btn-primary btn-recharge-list" type="button">文件导入</button>
		                       </sec:authorize>
		                       <sec:authorize access="hasRole('ROLE_BATCH_RECHARGE_DOWNLOAD_FILE')">
		                                    <button class="btn btn-primary btn-mould-download" type="button">模板下载</button>
		                        </sec:authorize>
	                    </div>
	           		</div>
	  			</div>
			</div>
			<div class="control-group formSep">
				<table cellpadding="5px" style="width: 100%">
					<tr>
						<td>
							<label class="control-label" style="font-weight: bold;">订单数量:</label>
			      			<label style="color: red;">${count }</label>
						</td>
						<td>
							<label class="control-label" style="font-weight: bold;">充值总金额:</label>
				      		<label style="color: red;">${sumMoney }</label>元
						</td>
						<td>
							<label class="control-label" style="font-weight: bold;">账户类型:</label>
							<label style="color: red;">${accountType.value }</label>
						</td>
					</tr>
				</table>
			</div>
         	</br >  
         	<div>
         	<%--<sec:authorize access="hasRole('ROLE_BATCH_RECHARGE_ORDERLISTCOMMIT')">
         		<button class="btn btn-primary btn-addRecharge" type="button">添加</button>
         	</sec:authorize>
         	</div>
         	<br/>--%>
         	<table class="table table-striped table-bordered dTableR table-hover" id="dt_gal" >
			<thead>
				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>身份证号码</th>
					<th>手机号</th>
					<th>充值金额(元)</th>
					<%--<th>操作</th>--%>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entity" items="${pageInfo.list}" varStatus="st">
					<tr>
						<td>${st.index+1 }</td>
						<td>${entity.userName}</td>
						<td>${entity.userCardNo}</td>
						<td>${entity.phoneNo}</td>
						<td>${entity.amount}</td>
						<%--<td>
						<sec:authorize access="hasRole('ROLE_BATCH_RECHARGE_ORDERLISTDELETE')">
						<a accountInfPuid="${entity.puId }" title="删除" class="btn-mini btn-delete" href="#"><i class="icon-remove"></i></a>
						</sec:authorize>
						</td>--%>
					</tr>
				</c:forEach>
			</tbody>
         	</table>
         	<%@ include file="/WEB-INF/views/common/pagination.jsp"%>
      		<br/>
			<sec:authorize access="hasRole('ROLE_BATCH_RECHARGE_ADDCOMMIT')">
			<button class="btn btn-primary btn-sub" type="submit">保存</button> 
			 </sec:authorize>
			<a href="${ctx }/batch/recharge/listRecharge.do"><button class="btn btn-primary" type="button">返回</button></a>
      	</form>
   		</div>
    </div>
    
	<div id="rechargeListModal" class="modal hide fade" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-header">
			<button class="close" data-dismiss="modal">&times;</button>
			<h3>文件导入</h3>
		</div>
		<form id="uploadMainForm" action="${ctx}/common/excelImport/excelImp.do"  method="post" enctype="multipart/form-data">
			<div class="modal-body">
				<div class="control-group">
					<div class="controls" style="text-align: center;">
						<div data-provides="fileupload" class="fileupload fileupload-new"><input type="hidden" />
							<span class="control-label">上传文件 ：</span>
							<div class="input-append">
								<div class="uneditable-input"><i class="icon-file fileupload-exists"></i> <span class="fileupload-preview"></span></div><span class="btn btn-file"><span class="fileupload-new">选择文件</span><span class="fileupload-exists">重新选择</span><input type="file"  name="file"/></span><a data-dismiss="fileupload" class="btn fileupload-exists" href="#">删除文件</a>
							</div>
						</div>
					</div>
				</div>
				<div style="text-align: center;">
				    <button class="btn btn-primary" type="submit">导 入  </button>
				</div>
			</div>
		</form>
	</div>  
    
    
	<div id="addRechargeModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<form class="form-horizontal">
		    <div class="modal-header">
		        <button class="close" data-dismiss="modal">&times;</button>
		        <h3 id="commodityInfModal_h">添加名单</h3>
		    </div>
		    <div class="modal-body">
		        <input type="hidden" id="commodity_id" />
		        <fieldset>
		            <div class="control-group">
		                <label class="control-label">姓名：</label>
		                <div class="controls">
		                    <input type="text" class="span3" id="name"/>
		                    <span class="help-block"></span>
		                </div>
		            </div>
		            <div class="control-group">
		                <label class="control-label">手机号码：</label>
		                <div class="controls">
		                    <input type="text" class="span3" id="phone" />
		                    <span class="help-block"></span>
		                </div>  
		            </div>
		            <div class="control-group">
		                <label class="control-label">身份证号码：</label>
		                <div class="controls">
		                    <input type="text" class="span3" id="card" />
		                    <span class="help-block"></span>
		                </div>
		            </div>
		            <div class="control-group">
		                <label class="control-label">金 额：</label>
		                <div class="controls">
		                    <input type="text" class="span3" id="money" />
		                    <span class="help-block"></span>
		                </div>
		            </div>
		        </fieldset>
		    </div>
		</form>
		<div class="modal-footer" style="text-align: center;">
		<sec:authorize access="hasRole('ROLE_BATCH_RECHARGE_ORDERCOMMIT')">
		    <button class="btn btn-primary btn-submit">确 定  </button>
		</sec:authorize>
		    <button class="btn" data-dismiss="modal" aria-hidden="true">取 消</button>
		</div>
	</div>        
	<div id="imorptMsg" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="height: 200px;">
		<div class="modal-header">
			<h3 id="commodityInfModal_h">温馨提示</h3>
		</div>
		<br/><br/><br/>
		<h3 align="center">文件上传中......</h3>
	</div> 
	<div id="msg" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="height: 200px;">
		<div class="modal-header">
		      <h3 id="commodityInfModal_h">温馨提示</h3>
		</div>
		<br/><br/><br/>
		<h3 align="center">信息正在处理......</h3>
	</div>
</body>
</html>
