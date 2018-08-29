package contracts.messaging.payments

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label('paymentReceived')
    input {
        //  method must be defined in base test class
        triggeredBy('triggerPaymentReceived("abc")')
    }
    outputMessage {
        // message channel name (topic or queue or sth else)
        sentTo('paymentsQueue')
        headers { messagingContentType(applicationJson()) }
        body('paymentId': 'abc',
                'status': 'Paid')
    }
}
