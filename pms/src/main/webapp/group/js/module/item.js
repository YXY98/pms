
define(['lib/jquery', 'util/funcTpl'], function($,funcTpl) {
     
    var item = {
        init:function(){
            console.log(2)
            console.log(item.tpl);
            $("#index").append(funcTpl(item.tpl));
        },
        tpl:function(){

        }

    }
    return item.init;
});


