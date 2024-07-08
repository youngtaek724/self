let hotelService = (function (){
    function showTop10Hotels(local, callback, error){
        $.ajax({
            url: "/main/home/"+local,
            type: "post",
            data: JSON.stringify(local),
            contentType: "application/json; charset=utf-8",
            success: function (result){
                if(callback){
                    callback(result);
                }
            },
            error: function (a,b,c){
                if(error){
                    console.error(a,b,c);
                }
            }
        });
    }
    return{showTop10Hotels: showTop10Hotels}
})();