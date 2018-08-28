import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method(GET())
        url("/payments/status/abcde")
    }
    response {
        status(OK())
        headers {
            contentType(applicationJson())
        }
        body("status": "Status for id: [abcde]: OK")
    }
}
