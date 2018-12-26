<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>
                                订单ID
                            </th>
                            <th>
                                订单总金额
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                ${orderDTO.orderId}
                            </td>
                            <td>
                                ${orderDTO.orderAmount}
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <#--订单详情表-->
                <div class="col-md-12 column">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>
                                商品ID
                            </th>
                            <th>
                                商品名称
                            </th>
                            <th>
                                价格
                            </th>
                            <th>
                                数量
                            </th>
                            <th>
                                总额
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderDTO.orderDetails as list>
                            <tr>
                            <td>
                            ${list.productId}
                            </td>
                            <td>
                            ${list.productName}
                            </td>
                            <td>
                            ${list.productPrice}
                            </td>
                            <td>
                            ${list.productQuantity}
                            </td>
                            <td>
                            ${list.productPrice * list.productQuantity}
                            </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-12 column">
                    <#if orderDTO.orderStatusEnum.message == "新订单">
                        <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-primary">完结订单</a>
                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-danger">取消订单</a>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>