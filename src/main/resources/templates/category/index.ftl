<html xmlns="http://www.w3.org/1999/html">
<#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">
<#--边栏sidebar-->
    <#include "../common/nav.ftl">
<#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label>类目名称</label>
                            <input name="categoryName" type="text" class="form-control"
                                   value="${(category.categoryName)!""}"/>
                        </div>
                        <div class="form-group">
                            <label>类目type</label>
                            <input name="categoryType" type="number" class="form-control"
                                   value="${(category.categoryType)!""}"/>
                        </div>
                        <input type="text" name="categoryId" value="${(category.categoryId)!""}" hidden>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>