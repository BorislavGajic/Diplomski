import { TestBed } from '@angular/core/testing';

import { OperaterServiceService } from './operater-service.service';

describe('OperaterServiceService', () => {
  let service: OperaterServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OperaterServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
