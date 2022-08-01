import { TestBed } from '@angular/core/testing';

import { EmpManagementServicesService } from './emp-management-services.service';

describe('EmpManagementServicesService', () => {
  let service: EmpManagementServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmpManagementServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
