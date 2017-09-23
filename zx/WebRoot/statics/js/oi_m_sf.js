jQuery(function(){
    $("#staff_info_other").on("click","a.weui-cell",function(){
        /*个人信息修改：
         1.邮箱地址
         2.手机号码
         3.修改密码
         */
        var _self=$(this);
        switch(_self.attr("id")){
            case "sf_clk_changeMail":
                $.prompt({
                    title: '修改邮箱',
                    text: '请输入合法的邮箱地址',
                    empty: false, // 是否允许为空
                    onOK: function (input) {
                        //点击确认
                        _self.children(".weui-cell__ft").html(input)
                    },
                    onCancel: function () {
                        //点击取消
                    }
                });
                break;
            case "sf_clk_changeTel":
                $.prompt({
                    title: '修改手机',
                    text: '请输入可用的手机号码',
                    empty: false, // 是否允许为空
                    onOK: function (input) {
                        //点击确认
                        _self.children(".weui-cell__ft").html(input)
                    },
                    onCancel: function () {
                        //点击取消
                    }
                });
                break;
            case "sf_clk_changePswd":
                $.prompt({
                    title: '修改密码',
                    text: '请输入6位以上密码',
                    empty: false, // 是否允许为空
                    onOK: function (input) {
                        //点击确认
                        $.confirm(input,"修改之后的密码");
                    },
                    onCancel: function () {
                        //点击取消
                    }
                });
                break;
        }
    })
});
