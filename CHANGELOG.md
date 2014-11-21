## 3.1.0 - November 20, 2014

- Added `currency` field to connect.* classes to make them SEPA (EUR payments) compatible (https://github.com/gocardless/gocardless-java/pull/31)

## 3.0.0 - October 30, 2014
**Note:** The rename of `payoutId` on `Bill` means that this release breaks compatibility with any `Bill` objects serialized with a previous version of
    this library. We strongly recommend against long-term storage of serialized objects produced by Java's built-in object serialization, as this mechanism
    is very brittle under small changes to object structure.

- Fixed `payoutId` on `Bill` (was previously called `paymentId` and was never populated) (https://github.com/gocardless/gocardless-java/pull/28)
- Added `cancel`, `retry`, and `refund` to `Bill`s (https://github.com/gocardless/gocardless-java/pull/25)

## 2.1.0 - March 28, 2014

- Added `setup_fee` field to `PreAuthorization`s (https://github.com/gocardless/gocardless-java/issues/9)
- Added convenience method for fetching `PreAuthorization`s
- Explicitly specified minimum required version for `commons-code` (https://github.com/gocardless/gocardless-java/issues/8)
- Added payouts API support (https://github.com/gocardless/gocardless-java/pull/19)
- Internal test harness refactor (https://github.com/gocardless/gocardless-java/pull/23)
- Added `charge_customer_at` field for `Bill`s
- Fixed `Bill` `Date` deserialisation bug (https://github.com/gocardless/gocardless-java/pull/21)

## 2.0.0 - October 18, 2013

- Dropped support for pre-Java 6
- Dependency updates
- Added `chargeCustomerAt` field to `Bill`s
- Moved to using `URI`s instead of plain `String`s for URI-related methods (`getUri` etc.)
- `SignatureException` is now a checked exception (previously it extended `RuntimeException`)

## 1.1.1 - August 29, 2012

- Fixed incorrect confirm path

## 1.1.0 - August 20, 2012

- Added setup_fee argument to subscription urls


