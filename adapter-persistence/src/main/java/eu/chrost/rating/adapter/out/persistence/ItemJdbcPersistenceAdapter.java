package eu.chrost.rating.adapter.out.persistence;

import eu.chrost.rating.application.port.in.query.ItemSummary;
import eu.chrost.rating.application.port.out.LoadItemPort;
import eu.chrost.rating.application.port.out.LoadItemSummaryPort;
import eu.chrost.rating.application.port.out.UpdateItemPort;
import eu.chrost.rating.domain.Item;
import eu.chrost.rating.domain.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ItemJdbcPersistenceAdapter implements LoadItemPort, LoadItemSummaryPort, UpdateItemPort {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Item> loadItem(String id) {
        List<Rating> ratings = jdbcTemplate.query(
                "SELECT value, review FROM ratings WHERE item_id = ?",
                (rs, rowNum) -> new Rating(rs.getDouble("value"), rs.getString("review")),
                id);
        if (ratings.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(Item.build(id, ratings));
        }
    }

    @Override
    public Optional<ItemSummary> loadItemSummary(String id) {
        return Optional.ofNullable(jdbcTemplate.query(
                "SELECT count(*) as count, AVG(value) as avg FROM ratings WHERE item_id = ?",
                rs -> {
                    if (rs.next()) {
                        long count = rs.getLong("count");
                        if (count > 0) {
                            double avg = rs.getDouble("avg");
                            return new ItemSummary(count, avg);
                        }
                    }
                    return null;
                },
                id));
    }

    @Override
    public void updateItem(Item item) {
        jdbcTemplate.update("DELETE FROM ratings");
        for (Rating rating: item.getRatings()) {
            jdbcTemplate.update("INSERT INTO ratings(item_id, value, review) VALUES(?, ?, ?)",
                    item.getId(), rating.getValue(), rating.getReview());
        }
    }
}
