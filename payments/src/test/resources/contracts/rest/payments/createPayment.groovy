package contracts.rest.payments

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method(POST())
        headers { accept(applicationJson()) }
        url('/payments/create')
        body('12345-abcd')
    }

    response {
        status(OK())
        headers { contentType(applicationJson()) }
        body('id': '12345-abcd',
             'status': 'Payment created')
    }
}
