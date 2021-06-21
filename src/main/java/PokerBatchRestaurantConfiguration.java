import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class PokerBatchRestaurantConfiguration {

    private static final String JOB_NAME = "LOAD_RESTAURANT_JOB";

    @Autowired
    private JobBuilderFactory jobBuilderFactory;


    @Autowired
    private Step loadingPractitionerStep;


    @Bean
    public Job job() {
        return jobBuilderFactory.get(JOB_NAME)
                .incrementer(new RunIdIncrementer())
                .start(loadingPractitionerStep)
                .listener(endJobListener())
                .build();
    }

    @Bean
    public Object endJobListener() { // Todo configuer listener.
        return new Object();
    }
}
