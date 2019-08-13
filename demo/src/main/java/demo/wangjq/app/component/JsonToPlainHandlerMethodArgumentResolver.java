package demo.wangjq.app.component;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.io.IoUtil;
import demo.wangjq.app.annotaation.GetJsonProperty;

/**
 * @author:wangjq
 * @Date: 2019/8/12 15:25
 */
public class JsonToPlainHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private ThreadLocal<Map<String, Object>> mapThreadLocal = new ThreadLocal<>();

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(GetJsonProperty.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Class<?> parameterType = parameter.getParameterType();
        getJson(webRequest);
        //Object arg = null;

        Map<String, Object> map = mapThreadLocal.get();
        //如果是基本数据类型直接返回
        if (isPrimitive(parameterType)) {
            return map.get(Objects.requireNonNull(parameter.getParameterName()));
        }
        //如果是String直接返回
        if (String.class.equals(parameterType)) {
            return map.get(Objects.requireNonNull(parameter.getParameterName()));
        }
//        Field[] fields = FieldUtil.getDeclaredFields(parameterType);
//        Object result = parameterType.newInstance();
//        for (Field field : fields) {
//            arg = map.get(field.getName());
//            if (arg == null) continue;
//            if (isPrimitive(field.getType())) {
//                Class<?> parType = field.getType();
//                arg = getArg(parType, arg);
//            }
//            Method setter = getSetterMethod(parameterType, field);
//            if (setter != null) setter.invoke(result, arg);
//        }
        return null;
    }

    private boolean isPrimitive(Class<?> clazz) {
        return Integer.class.equals(clazz) ||
                Double.class.equals(clazz) ||
                Float.class.equals(clazz) ||
                Boolean.class.equals(clazz) ||
                Long.class.equals(clazz) ||
                Byte.class.equals(clazz) ||
                Short.class.equals(clazz) ||
                clazz.isPrimitive();

    }


    private void getJson(NativeWebRequest webRequest) throws IOException {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        Map<String, Object> map;
        if (request != null) {
            if (mapThreadLocal.get() != null) {
                InputStream inputStream = request.getInputStream();
                String read = IoUtil.read(inputStream, StandardCharsets.UTF_8);
                map = com.alibaba.fastjson.JSON.parseObject(read);
                mapThreadLocal.set(map);
            }
        } else {
            throw new IllegalArgumentException("无法转换为json");
        }
    }
}
