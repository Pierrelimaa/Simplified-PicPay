package picpay.Picpaychallenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class PicpayChallengeApplication

fun main(args: Array<String>) {
	runApplication<PicpayChallengeApplication>(*args)
}
