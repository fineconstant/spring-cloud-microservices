import org.springframework.cloud.contract.spec.Contract


Contract.make {
    request {
        method(GET())
        url("payments/status/abcde")
    }
    response {
        status(OK())
        body("Status for id: [abcde]: OK")
    }
}
