package picpay.Picpaychallenge.services.client.Notification

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(url = "https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", name = "NotificationEmail")
interface NotificationClient {

    @PostMapping
    fun noitifyClient(@RequestHeader("document") document: String ): NotifyResponse
}