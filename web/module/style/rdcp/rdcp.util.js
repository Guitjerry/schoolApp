//序列化表单为json格式
rdcp.serializeObject=function(obj){
        var o={};
        var a=$(obj).serializeArray();
        $.each(a,function(){
            if(o[this.name]){
                if(!o[this.name].push){
                    o[this.name]=[0[this.name]]
                }
                o[this.name].push(this.value||'')
            }else{
                o[this.name]=this.value||''
            }
        })
        return o;
}