package com.algaworks.algalog.domain.model

import java.math.BigDecimal
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
data class Delivery(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
//    @JoinColumn(name = "client_id") -> Not needed to include explicitly
    val client: Client,

    @Embedded
    val addressee: Addressee,

    val fee: BigDecimal,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    val status: StatusDelivery?,

    @Column(name = "request_date")
    val requestDate: OffsetDateTime?,

    @Column(name = "end_date")
    val endDate: OffsetDateTime?
)