import org.springframework.cloud.contract.spec.Contract


Contract.make {
    request {
        method(GET())
        url("payments/status/abcde123")
    }
    response {
        status(OK())
        body("Status for id: [abcde123]: OK")
    }
}
