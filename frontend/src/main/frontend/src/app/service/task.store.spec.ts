import { TestBed, inject } from '@angular/core/testing';

import { TastStoreService } from './task.store';

describe('TastStoreService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TastStoreService]
    });
  });

  it('should be created', inject([TastStoreService], (service: TastStoreService) => {
    expect(service).toBeTruthy();
  }));
});
