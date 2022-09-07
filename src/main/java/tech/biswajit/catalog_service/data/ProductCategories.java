package tech.biswajit.catalog_service.data;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product_categories")
public class ProductCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "product_name", nullable = false, length = 255, unique = true)
    private String name;

    @Column(name = "product_desc", nullable = true, length = 255)
    private String description;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
}
