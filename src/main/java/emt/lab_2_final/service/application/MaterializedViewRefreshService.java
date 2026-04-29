package emt.lab_2_final.service.application;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MaterializedViewRefreshService {

    private final EntityManager entityManager;


    @Scheduled(fixedRateString = "${materialized.view.refresh.rate:20000}")
    @Transactional
    @SuppressWarnings("JpaQueryApiInspection")
    public void refreshBookCategoryStatsView() {
        log.info("Zapocnuvanje so refresh na materialized view: book_category_stats");

        try {
            entityManager.createNativeQuery("REFRESH MATERIALIZED VIEW book_category_stats").executeUpdate();
            log.info("Materialized view book_category_stats e uspesno zavrsen");
        } catch (Exception e) {
            log.error("Greska pri materialized view", e);
        }
    }
}
