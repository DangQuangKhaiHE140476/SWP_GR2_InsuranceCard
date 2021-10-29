-- VehicleType
INSERT INTO `insurancecardsystem1`.`vehicle_type` (`vehicletype`) VALUES ('UNDER _50CC');
INSERT INTO `insurancecardsystem1`.`vehicle_type` (`vehicletype`) VALUES ('ABOVE_50CC');
INSERT INTO `insurancecardsystem1`.`vehicle_type` (`vehicletype`) VALUES ('OTHER_TYPE_OF_MOTORBIKE');

-- InsuranceType
INSERT INTO `insurancecardsystem1`.`insurance_type` (`insurancetype`) VALUES ('COMPULSORY');
INSERT INTO `insurancecardsystem1`.`insurance_type` (`insurancetype`) VALUES ('OPTIONAL');

-- Role
INSERT INTO `insurancecardsystem1`.`role` (`role`) VALUES ('ADMIN');
INSERT INTO `insurancecardsystem1`.`role` (`role`) VALUES ('STAFF');
INSERT INTO `insurancecardsystem1`.`role` (`role`) VALUES ('CUSTOMER');

-- ContractStatus
INSERT INTO `insurancecardsystem1`.`contract_status` (`status`) VALUES ('REQUESTING');
INSERT INTO `insurancecardsystem1`.`contract_status` (`status`) VALUES ('ACTIVE');
INSERT INTO `insurancecardsystem1`.`contract_status` (`status`) VALUES ('TERMINATED');

-- CompensationStatus
INSERT INTO `insurancecardsystem1`.`compensation_status` (`value`) VALUES ('PAID');
INSERT INTO `insurancecardsystem1`.`compensation_status` (`value`) VALUES ('UNPAID');

-- AccidentStatus
INSERT INTO `insurancecardsystem1`.`accident_status` (`status`) VALUES ('APPROVE');
INSERT INTO `insurancecardsystem1`.`accident_status` (`status`) VALUES ('REJECT');
INSERT INTO `insurancecardsystem1`.`accident_status` (`status`) VALUES ('VERIFYING');

-- PaymentType
INSERT INTO `insurancecardsystem1`.`payment_type` (`type`) VALUES ('NEW_CONTRACT');
INSERT INTO `insurancecardsystem1`.`payment_type` (`type`) VALUES ('PUNISHMENT');

-- PunishmentStatus
INSERT INTO `insurancecardsystem1`.`punishment_status` (`status`) VALUES ('PAID');
INSERT INTO `insurancecardsystem1`.`punishment_status` (`status`) VALUES ('UNPAID');
INSERT INTO `insurancecardsystem1`.`punishment_status` (`status`) VALUES ('OVERDUE');

-- RequestType
INSERT INTO `insurancecardsystem1`.`request_type` (`type`) VALUES ('NEW_CONTRACT');
INSERT INTO `insurancecardsystem1`.`request_type` (`type`) VALUES ('RENEW_CONTRACT');
INSERT INTO `insurancecardsystem1`.`request_type` (`type`) VALUES ('CANCEL_CONTRACT');
INSERT INTO `insurancecardsystem1`.`request_type` (`type`) VALUES ('ACCIDENT_REPORT');
INSERT INTO `insurancecardsystem1`.`request_type` (`type`) VALUES ('REQUEST_COMPENSATION');

-- RequestStatus
INSERT INTO `insurancecardsystem1`.`request_status` (`status`) VALUES ('PROCESSING');
INSERT INTO `insurancecardsystem1`.`request_status` (`status`) VALUES ('RESOLVED');
