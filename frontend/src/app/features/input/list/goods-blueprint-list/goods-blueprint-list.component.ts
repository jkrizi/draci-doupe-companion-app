import {Component, OnDestroy, OnInit} from '@angular/core';
import {GoodsBlueprintModel} from '../../../../models/goods-blueprint.model';
import {GoodsBlueprintService} from '../../../../services/goods-blueprint.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-goods-blueprint-list',
  templateUrl: './goods-blueprint-list.component.html',
  styleUrls: ['./goods-blueprint-list.component.css']
})
export class GoodsBlueprintListComponent implements OnInit, OnDestroy {
  private listSub: Subscription;

  goodsBlueprints: GoodsBlueprintModel[];

  constructor(private goodsBlueprintService: GoodsBlueprintService) { }

  ngOnInit() {
    this.goodsBlueprintService.getAll();
    this.listSub = this.goodsBlueprintService.goodsBlueprintList.subscribe( goodsBlueprints => this.goodsBlueprints = goodsBlueprints);
  }

  ngOnDestroy(): void {
    this.listSub.unsubscribe();
  }

  selectGoodsBlueprint(index: number) {
    this.goodsBlueprintService.select(this.goodsBlueprints[index]);
  }
}
