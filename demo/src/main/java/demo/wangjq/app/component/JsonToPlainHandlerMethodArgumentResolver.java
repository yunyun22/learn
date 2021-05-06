//package demo.wangjq.app.component;
//
//import org.springframework.core.MethodParameter;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.support.WebDataBinderFactory;
//import org.springframework.web.context.request.NativeWebRequest;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.ModelAndViewContainer;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import cn.hutool.core.convert.Convert;
//import cn.hutool.core.io.IoUtil;
//
///**
// * @author:wangjq
// * @Date: 2019/8/12 15:25
// */
//public class JsonToPlainHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
//
//    private ThreadLocal<Map<String, Object>> mapThreadLocal = new ThreadLocal<>();
//
//    @Override
//    public boolean supportsParameter(MethodParameter parameter) {
//        return false;
//    }
//
//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        Class<?> parameterType = parameter.getParameterType();
//        getJson(webRequest);
//
//        //GetJsonProperty annotation = parameter.getParameterAnnotation(GetJsonProperty.class);
//        if (annotation != null) {
//            String name = annotation.value();
//            String[] split;
//            if (StringUtils.hasText(name)) {
//                split = name.split("\\.");
//            } else {
//                split = new String[]{parameter.getParameterName()};
//            }
//            Map<String, Object> map = mapThreadLocal.get();
//            if (isPrimitive(parameterType)) {
//                return recurGetValue(split, map);
//            }
//            if (String.class.equals(parameterType)) {
//                return recurGetValue(split, map);
//            }
//            if (List.class.equals(parameterType)) {
//                return recurGetValue(split, map);
//            }
//            if (Map.class.equals(parameterType)) {
//                return recurGetValue(split, map);
//            }
//            return Convert.convert(parameterType, recurGetValue(split, map));
//        }
//        return null;
//    }
//
//
//    private Object recurGetValue(String[] keys, Map<String, Object> map) {
//        int i = 0;
//        Object ret = map;
//        for (String key : keys) {
//            if (i == 0) {
//                ret = map.get(key);
//            } else if (ret instanceof Map) {
//                ret = ((Map) ret).get(key);
//            } else {
//                throw new RuntimeException("无法解析参数");
//            }
//
//            i++;
//        }
//        return ret;
//    }
//
//
//    private boolean isPrimitive(Class<?> clazz) {
//        return Integer.class.equals(clazz) ||
//                Double.class.equals(clazz) ||
//                Float.class.equals(clazz) ||
//                Boolean.class.equals(clazz) ||
//                Long.class.equals(clazz) ||
//                Byte.class.equals(clazz) ||
//                Short.class.equals(clazz) ||
//                clazz.isPrimitive();
//
//    }
//
//
//    private void getJson(NativeWebRequest webRequest) throws IOException {
//        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
//        Map<String, Object> map;
//        if (request != null) {
//            if (mapThreadLocal.get() == null) {
//                InputStream inputStream = request.getInputStream();
//                String read = IoUtil.read(inputStream, StandardCharsets.UTF_8);
//                map = com.alibaba.fastjson.JSON.parseObject(read);
//                mapThreadLocal.set(map);
//            }
//        } else {
//            throw new IllegalArgumentException("无法转换为json");
//        }
//    }
//}
