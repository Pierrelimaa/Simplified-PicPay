package picpay.Picpaychallenge.services.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping


@FeignClient(url= "https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", name = "Authenticator")
interface AuthorizerClient {

    @GetMapping
    fun authorizeTransaction(): AuthorizerResponse
}