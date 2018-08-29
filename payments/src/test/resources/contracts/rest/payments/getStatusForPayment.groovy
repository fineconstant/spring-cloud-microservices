package contracts.rest.payments

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method(GET())
        url('/payments/status/abcde')
    }
    response {
        status(OK())
        headers {
            contentType(applicationJson())
        }
        body('id': 'abcde',
             'status': 'OK',
             'description': 'Success!')
    }
}
