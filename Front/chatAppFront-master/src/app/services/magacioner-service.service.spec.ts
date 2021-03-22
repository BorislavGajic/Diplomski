import { TestBed } from '@angular/core/testing';

import { MagacionerServiceService } from './magacioner-service.service';

describe('MagacionerServiceService', () => {
  let service: MagacionerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MagacionerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
