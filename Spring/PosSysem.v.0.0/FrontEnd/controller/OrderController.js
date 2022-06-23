getAllIds()
function getAllIds() {

    $.ajax({
        url:"http://localhost:8080/pos_war/customer/getIds",
        method: "GET",


        success: function (resp) {
            if(resp.code == 200){

                console.log("helloooooo")
                console.log(resp.data);
                var str = '';
                for(const  ids of resp.data){

                    str += '<option value="'+ids+'" />';

                }
                var my_list = document.getElementById("customerIdList");
                my_list.innerHTML = str;

            }

        }

    })

}



getAllItemCodes()
function getAllItemCodes() {

    $.ajax({
        url:"http://localhost:8080/pos_war/item/getIds",
        method:"GET",
        success: function (resp) {
            if(resp.code == 200){

                var str  = '';
                for (const ids of resp.data){
                    str += '<option value="'+ids+'" />';

                }
                var my_list = document.getElementById("itemIdList");
                my_list.innerHTML = str;
            }
        }
    })

}


$("#itemIdOrder").keyup(function (event) {

    if(event.keyCode == 13){
        let cusId  = $("#itemIdOrder").val();

        $.ajax({
            url:"http://localhost:8080/pos_war/item/search?id="+cusId,
            method: "GET",

            success: function (resp) {

                if(resp.code == 200){
                    $("#itemNameOrder").val(resp.data.itemName);
                    $("#itemPriceOrder").val(resp.data.unitPrice);
                    $("#itemPackSizeOrder").val(resp.data.packSize);
                    $("#itemQtyOrder").val(resp.data.quantity);

                }

            }
        })
        $("#saleItemQty").focus();
    }


})

let customerDto;
$("#cusIdOrder").keyup(function (event) {

    if(event.keyCode == 13){
        let cusId  = $("#cusIdOrder").val();

        $.ajax({
            url:"http://localhost:8080/pos_war/customer/search?id="+cusId,
            method: "GET",

            success: function (resp) {

                if(resp.code == 200){
                    customerDto = resp.data;
                    // console.log(customerDto);



                    $("#cusNameOrder").val(resp.data.firstName);
                    $("#cusAddressOrder").val(resp.data.address);
                    $("#cusEmailOrder").val(resp.data.email);
                    $("#cusTelOrder").val(resp.data.telNo);

                }
            }
        })


        $("#itemIdOrder").focus();
    }


})


/*-------------------------------Customer Order part ----------------------------------*/


//$("#addToCart").prop("disabled","true");
$("#itemPay").prop("disabled","true");
$("#btnDelOrder").prop('disabled',true);
$("#btnUpdOrder").prop('disabled',true);




$("#cusNameOrder").attr('disabled', true);
$("#cusAddressOrder").attr('disabled', true);
$("#cusTelOrder").attr('disabled', true);
$("#cusEmailOrder").attr('disabled', true);


$("#itemPriceOrder").attr('disabled', true);
$("#itemNameOrder").attr('disabled', true);
$("#itemQtyOrder").attr('disabled', true);
$("#itemPackSizeOrder").attr('disabled', true);
$("#itemTotalPrice").attr('disabled', true);
$("#allItemTotalFee").attr('disabled', true);





function clearOrderTextField() {
    $("#cusIdOrder").val("");
    $("#cusNameOrder").val("");
    $("#cusAddressOrder").val("");
    $("#cusTelOrder").val("");
    $("#cusEmailOrder").val("");


    $("#allItemTotalFee").val("");


}


function clearOrderTextFieldPart2() {
    $("#itemIdOrder").val("");
    $("#itemNameOrder").val("");
    $("#itemQtyOrder").val("");
    $("#itemPackSizeOrder").val("");
    $("#itemPriceOrder").val("");


    $("#saleItemQty").val("");
    $("#itemTotalPrice").val("");
}







/*======================dashBord=======================*/
function calAllProfit(){

    let allProfit =0;
    for(let i =0; i< order.length; i++){

        let profit =  order[i].getProfit();
        let profitNum  =  parseInt(profit);

        allProfit = allProfit + profitNum;
        console.log("all profit ------ " + allProfit);
    }

    $("#businessProfit").text(allProfit);

}











$("#saleItemQty").keyup(function (event) {

    let itemUnitPrice = $("#itemPriceOrder").val();
    let priceNum = parseInt(itemUnitPrice);

    if(event.keyCode == 13){
        let itemQty = $("#itemQtyOrder").val();
        let itemQtyNum = parseInt(itemQty);

        let qty = $("#saleItemQty").val();


        if(qty >= 0){
            if(qty.length >=1){
                if(itemQtyNum > qty){
                    let itemPrice =  qty * priceNum;
                    $("#validationQty").text("");
                    $("#itemTotalPrice").attr('disabled', false);
                    $("#itemTotalPrice").val(itemPrice);
                    $("#itemTotalPrice").focus();

                }else{
                    $("#validationQty").text("please input amount lower than :"+ itemQtyNum);
                    $("#validationQty").css("color", "red");
                    $("#validationQty").css("font-weight", "bold");

                }

            }else{

                $("#validationQty").text("please input qty");
                $("#validationQty").css("color", "red");
                $("#validationQty").css("font-weight", "bold");

            }

        }else{

            $("#validationQty").text("please not input negative number");
            $("#validationQty").css("color", "red");
            $("#validationQty").css("font-weight", "bold");


        }




    }
})





/*  ======================================part=======================*/
let cartArray = new Array();

$("#addToCart").click(function () {

    let itemCode =  $("#itemIdOrder").val();
    let itemName = $("#itemNameOrder").val();
    let customerId  =  $("#cusIdOrder").val();
    let unitPrice  =  $("#itemPriceOrder").val();
    let saleQty =  $("#saleItemQty").val();
    let price  =  $("#itemTotalPrice").val();
    $("#itemPay").prop("disabled",false);


    let cartDTO = new CartDTO();
    cartDTO.setItemCode(itemCode);
    cartDTO.setItemName(itemName);
    cartDTO.setCustomerCode(customerId);
    cartDTO.setUnitPrice(unitPrice);
    cartDTO.setSaleQty(saleQty);
    cartDTO.setPrice(price);



    let allItemProfit = 0;

    console.log("cart array work")
    if(confirm("Are you sure, you want add this order")){
        if(checkCartArray()){

        }else{
            cartArray.push(cartDTO);
            addOrderCartRow();
            addSumTotalPrice();
        }



        if(cartArray.length === 0){
            cartArray.push(cartDTO);
            addOrderCartRow();
            addSumTotalPrice();
        }
    }else {

    }



})

function checkCartArray() {
    for(let i =0; i < cartArray.length ; i++){
        if(cartArray[i].getItemCode() === $("#itemIdOrder").val()){
            return true;

        }else{

        }

        //getDateAndTime();
        // allItemProfit = allItemProfit + countSaleProfit(cartDTO.getItemCode());
        //  console.log(allItemProfit);
        //tableRowClickCart();
        //clearOrderTextFieldPart2();
        //$("#itemTotalPrice").attr('disabled', true);

    }

}




/* ===========================================================================================================  */

function addOrderCartRow() {

    $("#orderCartTable").empty();
    for (var i =0; i <cartArray.length; i++){
        let newRow = `<tr><td>${cartArray[i].getItemCode()}</td></td><td>${cartArray[i].getCustomerCode()}</td><td>${cartArray[i].getItemName()}
                </td><td>${cartArray[i].getUnitPrice()}</td><td>${cartArray[i].getSaleQty()}</td><td>${cartArray[i].getPrice()}</td></tr>`;
        $("#orderCartTable").append(newRow);
    }
}
function  addSumTotalPrice() {
    let totalPrice = 0;
    for(let i =0; i < cartArray.length;i++){
        let price = parseInt(cartArray[i].getPrice())
        totalPrice = totalPrice + price;
    }
    $("#allItemTotalFee").val(totalPrice);
}

/* ===========================================================================================================  */


const dataArray = [];
function createObject() {
    let orderId = $("#lblOrderId").text();
    for(let i=0; i < cartArray.length; i++){
        const obj= {
            "orderId":orderId,
            "itemCode": cartArray[i].getItemCode(),
            "saleQty":cartArray[i].getSaleQty(),
            "saleItemPrice":cartArray[i].getPrice(),
            "profit":20
        }

        console.log("itemCode ======", cartArray[i].getItemCode());

        dataArray.push(obj);


    }

}




$("#itemPay").click(function () {

    let orderId = $("#lblOrderId").text();
    let customerId = $("#cusIdOrder").val();
    let sale =  $("#allItemTotalFee").val();
    let profit =calculateCustomerAllItemProfit();
    let dateAndTime = getDateAndTime();

    createObject();



    //let saleText =  sale.toString();
    //let profitText = profit.toString();



    console.log(customerDto);
    console.log(dateAndTime);
    console.log(sale);
    console.log(typeof (sale))




    let jsonData  = JSON.stringify({
        "orderId": orderId,
        "totalPrice": parseFloat(sale),
        "profit": profit,
        "dataAndTime": dateAndTime,
        "customerDto":customerDto,
        "orderDetailLists": dataArray

    });



    $.ajax({
        url: "http://localhost:8080/pos_war/order",
        method: "POST",
        data: jsonData,
        contentType: "application/json",

        success:function (resp) {
            alert(resp.message);
            getOrderId();
            getOrderTable();
            clearOrderTextFieldPart2();
            clearOrderTextField();

            console.log("order post success");

        }





    })








    cartArray.splice(0, cartArray.length);
    addOrderCartRow();
    addOrderRow();
    getOrderId();



    /* clearOrderTextField();
     calAllProfit();
     calAllTodayOrder();
     calAllCustomers();
     calAllItems();*/




})



function addOrderRow() {

    $("#orderDashBord").empty();
    for (var i =0; i <order.length; i++){
        let newRow = `<tr><td>${order[i].getOrderId()}</td></td><td>${order[i].getCustomerId()}</td><td>${order[i].getSale()}
                </td><td>${order[i].getProfit()}</td><td>${order[i].getDateAndTime()}</td></tr>`;
        $("#orderDashBord").append(newRow);
    }


}

function calculateCustomerAllItemProfit() {
    let totalProfit =0;
    //let itemQty = parseInt(qty);

    for(let i =0; i < cartArray.length;i++){
        totalProfit = totalProfit +( countSaleProfit(cartArray[i].getItemCode())* cartArray[i].getSaleQty());


    }
    return totalProfit;


}

function getDateAndTime() {
    let dateAndTime =  new Date();
    let hours = dateAndTime.getHours();
    let min = dateAndTime.getMinutes();
    let second  = dateAndTime.getSeconds();

    let day = dateAndTime.getDate();
    let month =  dateAndTime.getMonth();
    let year =  dateAndTime.getFullYear();

    let dateAndTime1 =hours + ":" + min + ":" + second +" "+ day + "-" + month + "-" + year;

    return  dateAndTime1;

}

function countSaleProfit(ItemCode) {
    let itemBuyingPrice = 0;
    let itemUnitPrice   = 0;


}


getOrderId();
function getOrderId() {


    $.ajax({
        url: "http://localhost:8080/pos_war/order/getId",
        method: "GET",

        success: function (resp) {
            if(resp.code == 200){
                console.log(resp.data)
                $("#lblOrderId").text(resp.data)
            }



        }


    })

}
