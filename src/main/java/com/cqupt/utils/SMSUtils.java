package com.cqupt.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

public class SMSUtils {
    public static void sendMessage(String signName,String templateCode,String phoneNum,String param){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou","LTAI5tCA5jVPDy32EJQqepik","cVnoWlje83umL1pIh6DjH41ut7yfyp");
        IAcsClient client = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        request.setSysRegionId("cn-hangzhou");
        request.setPhoneNumbers(phoneNum);
        request.setSignName(signName);
        request.setTemplateCode(templateCode);
//        System.out.println(param);
//        System.out.println("{\"code\":\""+param+"\"}");
//        System.out.println("{\"code\":\"1234\"}");
        request.setTemplateParam("{\"code\":\""+param+"\"}");
//        request.setTemplateParam("{\"code\":\"1234\"}");

        try {
            SendSmsResponse response =client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
            System.out.println("短信发送成功");
        } catch (ServerException e) {
            e.printStackTrace();
        }catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }

    }
}
