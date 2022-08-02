import { TestBed } from '@angular/core/testing';

import { EcomservicesService } from './ecomservices.service';

describe('EcomservicesService', () => {
  let service: EcomservicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EcomservicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
