package com.itcast.oa.test;

import com.itcast.oa.base.util.MatrixToImageWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by GanSX on 2017/3/15.
 */
@Controller
@RequestMapping("/user")
public class TestController {
    private static final Log logger = LogFactory.getLog(TestController.class);

    @RequestMapping("/gen.json")
    public void gen(String url, HttpServletResponse response, Integer width, Integer height ) {
        try {
            int iWidth = (width == null?200: width);
            int iHeight = (height==null?200: height);
            MatrixToImageWriter.createRqCode(url, iWidth, iHeight
                    , response.getOutputStream());
        } catch (Exception e) {
            logger.error(String.format("生成二维码失败： url： %s", url), e);
        }
    }
}
