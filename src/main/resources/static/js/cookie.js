var cookieUtil={
    createCookie:function (name,value,days){
        var expires="";
        if (days){
            var date=new Date();
            date.setTime(date.getTime()+(days*14*24*3600*1000));
            expires=";expires="+date.toGMTString();
        }
        document.cookie=name+"="+value+expires+";path=/";
    },
    /*设置cookie*/
    set:function(name,value,expires,path,domain,secure){
        var cookie=encodeURIComponent(name)+"="+encodeURIComponent(value);
        if(expires instanceof Date){
            cookie+="; expires="+expires.toGMTString();
        }else{
            var date=new Date();
            date.setTime(date.getTime()+expires*24*3600*1000);
            cookie+="; expires="+date.toGMTString();
        }
        if(path){
            cookie+="; path="+path;
        }
        if(domain){
            cookie+="; domain="+domain;
        }
        if (secure) {
            cookie+="; "+secure;
        }
        document.cookie=cookie;
    },
    /*获取cookie*/
    get:function(name){
        var cookieName=encodeURIComponent(name);
        /*正则表达式获取cookie*/
        var restr="(^| )"+cookieName+"=([^;]*)(;|$)";
        var reg=new RegExp(restr);
        var cookieValue=document.cookie.match(reg)[2];
        /*字符串截取cookie*/
        /*var cookieStart=document.cookie.indexOf(cookieName+“=”);
        var cookieValue=null;
        if(cookieStart>-1){
            var cookieEnd=document.cookie.indexOf(";",cookieStart);
            if(cookieEnd==-1){
                cookieEnd=document.cookie.length;
            }
            cookieValue=decodeURIComponent(document.cookie.substring(cookieStart
            +cookieName.length,cookieEnd));
        }*/
        return cookieValue;
    }
}
