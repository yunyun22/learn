//package demo.wangjq.mongo;
//
//import demo.wangjq.BaseTest;
//import demo.wangjq.app.domain.Question;
//import demo.wangjq.app.domain.QuestionTemplate;
//import demo.wangjq.app.dto.AggregateDto;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.aggregation.Aggregation;
//import org.springframework.data.mongodb.core.aggregation.AggregationResults;
//import org.springframework.data.mongodb.core.query.Criteria;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
//public class MongodbTest extends BaseTest {
//
//
//    private static final String COLLECTION_NAME = "QuestionTemplate";
//
//    private static final String INIT_ID = "000";
//
//    public static final String MAN = "MAN";
//    public static final String WOMAN = "WOMAN";
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//
//    private String QUESTION_ONE = "男/女";
//    private String QUESTION_TWO = "身高";
//    private String QUESTION_THREE = "年龄";
//
//
//    @Test
//    public void insertQuestionTemplate() {
//
//        Question questionOne = new Question();
//        questionOne.setQuestion(QUESTION_ONE);
//
//        Question questionTwo = new Question();
//        questionTwo.setQuestion(QUESTION_TWO);
//
//        Question questionThree = new Question();
//        questionThree.setQuestion(QUESTION_THREE);
//
//
//        List<Question> list = Arrays.asList(questionOne, questionTwo, questionThree);
//
//        Random ra = new Random();
//
//        for (int i = 1; i < 1001; i++) {
//            QuestionTemplate questionTemplate = new QuestionTemplate();
//            questionTemplate.setTemplateName("身体状态问卷");
//            questionTemplate.setQuestions(list);
//            questionTemplate.setId(INIT_ID + i);
//            String sex = ra.nextInt(2) == 0 ? MAN : WOMAN;
//            questionOne.setAnswer(sex);
//            String height = 170 + ra.nextInt(5) + "";
//            questionTwo.setAnswer(height);
//            String age = 0 + ra.nextInt(120) + "";
//            questionThree.setAnswer(age);
//
//            mongoTemplate.insert(questionTemplate, COLLECTION_NAME);
//        }
//
//    }
//
//    @Test
//    public void testGroupBy() {
//
//        Aggregation anwser = Aggregation.newAggregation(
//                Aggregation.unwind("questions"),
//                Aggregation.match(Criteria.where("questions.question").is("身高")),
//                Aggregation.group("questions.answer").count().as("count")
//
//        );
//
//        AggregationResults<AggregateDto> results = mongoTemplate.aggregate(anwser, "QuestionTemplate", AggregateDto.class);
//        System.out.println(results.getMappedResults());
//        System.out.println(results.getRawResults());
//
//
//    }
//
//
//}
